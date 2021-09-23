package Theme11MultithreadingPart2;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableThreadPool implements ThreadPool {
    private final int minNumberOfThreads;
    private final int maxNumberOfThreads;
    private int numberOfTreads = 0;
    private final LinkedBlockingQueue<Runnable> runnableQueue;
    private PoolWorker[] poolWorkers;

    public ScalableThreadPool(int minNumberOfThreads, int maxNumberOfThreads) {
        this.minNumberOfThreads = minNumberOfThreads;
        this.maxNumberOfThreads = maxNumberOfThreads;
        runnableQueue = new LinkedBlockingQueue<>();
        poolWorkers = new PoolWorker[maxNumberOfThreads];
    }

    @Override
    public void start() {
        for (int i = 0; i < minNumberOfThreads; i++) {
            poolWorkers[i] =  new PoolWorker();
            poolWorkers[i].start();

            numberOfTreads++;
        }
    }

    @Override
    public void execute(Runnable runnable) {
        runnableQueue.add(runnable);
    }

    private class PoolWorker extends Thread {
        @Override
        public void run() {
            Runnable runnable;
            while (true) {
                synchronized (runnableQueue) {
                    while (runnableQueue.isEmpty()) {
                        try {
                            runnableQueue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    runnable = runnableQueue.poll();
                }
                runnable.run();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1-start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1");
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("2-start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("3-start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3");
            }
        };
        Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                System.out.println("4-start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("4");
            }
        };
        ScalableThreadPool pool = new ScalableThreadPool(3, 4);
        pool.start();
        pool.execute(runnable1);
        pool.execute(runnable2);
        pool.execute(runnable3);
        pool.execute(runnable4);
        pool.execute(runnable4);
        pool.execute(runnable2);
        pool.execute(runnable2);
        pool.execute(runnable4);

    }
}
