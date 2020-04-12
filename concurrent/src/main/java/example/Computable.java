package example;

/**
 * @Author: Xuan Jing
 * @Date: 2020/4/11 7:05 PM
 */
public interface Computable<V, R> {

    R compute(V v) throws InterruptedException;
}
