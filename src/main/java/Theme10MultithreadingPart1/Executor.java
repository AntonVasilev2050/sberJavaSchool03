package Theme10MultithreadingPart1;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Executor {
    public static List<Integer> list = new ArrayList<>();

    public static void readFromDisk(String path) {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(list);
        readFromDisk("src/main/java/Theme10MultithreadingPart1/numbers.txt");
        System.out.println(list);
        List<Thread> threadList = new ArrayList<>();

//        Without concurrency
        long before = System.currentTimeMillis();
        for (int numberToCalculate : list) {
            System.out.println("Factorial of " + numberToCalculate + " - " + ExtraMath.factorialRecursion(numberToCalculate));
        }
        System.out.println("Processing time " + (System.currentTimeMillis() - before));

//        With concurrency
        int listSize = list.size();
        long beforeC = System.currentTimeMillis();
        for (int i = 0; i < listSize; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int numberToCalculate = list.get(finalI);
                    System.out.println("Factorial of " + numberToCalculate + " - " + ExtraMath.factorialRecursion(numberToCalculate));
                }
            });
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println("Processing time with concurrency " + (System.currentTimeMillis() - beforeC));


//        With concurrency and using a CountDownLatch
        long beforeWithLatch = System.currentTimeMillis();
        final CountDownLatch latch = new CountDownLatch(listSize);
        for (int i = 0; i < listSize; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int numberToCalculate = list.get(finalI);
                    System.out.println("Factorial of " + numberToCalculate + " - " + ExtraMath.factorialRecursion(numberToCalculate));
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println("Processing time with concurrency " + (System.currentTimeMillis() - beforeWithLatch));

//        With concurrency, two threads, using CountDownLatch
        long beforeTwo = System.currentTimeMillis();
        final CountDownLatch latch1 = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int numberToCalculate = list.get(i);
                    System.out.println("Factorial of " + numberToCalculate + " - " + ExtraMath.factorialRecursion(numberToCalculate));
                }
                latch1.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < listSize; i++) {
                    int numberToCalculate = list.get(i);
                    System.out.println("Factorial of " + numberToCalculate + " - " + ExtraMath.factorialRecursion(numberToCalculate));
                }
                latch1.countDown();
            }
        }).start();
        latch1.await();
        System.out.println("Processing time with two threads " + (System.currentTimeMillis() - beforeTwo));
    }
}
