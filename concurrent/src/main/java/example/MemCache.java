package example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: Xuan Jing
 * @Date: 2020/4/11 7:04 PM
 */
public class MemCache<V, R> implements Computable<V, R> {
    private final Map<V, Future<R>> cache = new ConcurrentHashMap<>();

    private final Computable<V, R> computable;

    public MemCache(Computable<V, R> computable) {
        this.computable = computable;
    }

    @Override
    public R compute(final V v) throws InterruptedException {
        Future<R> r = cache.get(v);
        if (r == null) {
            Future<R> rt = new FutureTask<>(() -> computable.compute(v));
            r = cache.putIfAbsent(v, rt);
            if (r == null) {
                r = rt;
                ((FutureTask<R>) rt).run();
            }
        }

        try {
            return r.get();
        } catch (ExecutionException e) {
            throw new InterruptedException();
        }
    }

    public R get(V v) throws ExecutionException,InterruptedException {
        return cache.get(v).get();
    }
}
