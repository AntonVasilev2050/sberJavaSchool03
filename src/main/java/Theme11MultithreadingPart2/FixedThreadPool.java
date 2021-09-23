package Theme11MultithreadingPart2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int numberOfThreads;
    private final LinkedBlockingQueue<Runnable> runnableQueue;

    public FixedThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        runnableQueue = new LinkedBlockingQueue();

    }

    private class PoolWorker extends Thread{
        @Override
        public void run() {
            Runnable runnable;
            while (true){
                synchronized (runnableQueue){
                    while (runnableQueue.isEmpty()){
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

    @Override
    public void start()  {
        for(int i = 0; i < numberOfThreads; i++){
            new PoolWorker().start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        runnableQueue.add(runnable);
//        runnableQueue.notifyAll();
    }

    public static void main(String[] args) {
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
        FixedThreadPool pool = new FixedThreadPool(3);
        pool.start();
        pool.execute(runnable1);
        pool.execute(runnable2);
        pool.execute(runnable3);
        pool.execute(runnable4);
        pool.execute(runnable4);
        pool.execute(runnable2);
        pool.execute(runnable4);

    }
}
