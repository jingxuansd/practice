package example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Xuan Jing
 * @Date: 2020/3/29 2:20 PM
 */
public class Main {

    static class IncTask implements Runnable {
        final int i;

        final MemCache<Integer, Integer> memCache;

        final CountDownLatch countDownLatch;

        public IncTask(int i , MemCache<Integer, Integer> memCache, CountDownLatch countDownLatch) {
            this.i = i;
            this.memCache = memCache;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                memCache.compute(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "'s compute is down!");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);

        final Computable<Integer, Integer> memCache = new MemCache<>(v -> ++v);
        for (int i=0; i<10; i++) {
            new Thread(new IncTask(i, (MemCache<Integer, Integer>) memCache, countDownLatch)).start();
        }

        countDownLatch.await();
        System.out.println("down");
        try {
            System.out.println("9's result is: " + ((MemCache<Integer, Integer>) memCache).get(9));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
