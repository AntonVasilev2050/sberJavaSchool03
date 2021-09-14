package Theme10MultithreadingPart1;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void main(String[] args) {
        System.out.println(list);
        readFromDisk("src/main/java/Theme10MultithreadingPart1/numbers.txt");
        System.out.println(list);
        for (int i= 0; i < list.size(); i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int numberToCalculate = list.get(finalI);
                    System.out.println("Factorial of " + numberToCalculate + " - " + ExtraMath.factorial(numberToCalculate));
                }
            }).start();
        }
    }
}
