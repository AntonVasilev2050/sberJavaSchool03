package Theme11MultithreadingPart2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class FixedThreadPool implements ThreadPool {
    private int numberOfThreads;
    private Queue<Runnable> runnableQueue = new LinkedList<>();
    private static final Object LOCK = new Object();

    public FixedThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void start() {
        CountDownLatch latch = new CountDownLatch(3);
        while (!runnableQueue.isEmpty()) {
            for (int i = 0; i < numberOfThreads; i++) {
                new Thread(runnableQueue.poll()).start();
                latch.countDown();
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        runnableQueue.add(runnable);
    }

    public static void main(String[] args) {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("3");
            }
        };
        Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                System.out.println("4");
            }
        };
        FixedThreadPool pool = new FixedThreadPool(3);
        pool.execute(runnable1);
        pool.execute(runnable2);
        pool.execute(runnable3);
        pool.execute(runnable4);
        pool.start();
    }
}
