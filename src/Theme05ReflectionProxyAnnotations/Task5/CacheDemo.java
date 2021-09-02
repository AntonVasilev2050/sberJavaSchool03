package Theme05ReflectionProxyAnnotations.Task5;

import Theme05ReflectionProxyAnnotations.Task01.Calculator;
import Theme05ReflectionProxyAnnotations.Task01.CalculatorImpl;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Scanner;

public class CacheDemo {
    private final static String enterANumber = "Enter a number(0..14): ";

    public static void main(String[] args) {
        Calculator delegate = new CalculatorImpl();
        Calculator calculator = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheInvocationHandler(delegate));
        DatabaseCache.cache = new HashMap<>();
        DatabaseCache.createCacheOnDisk(DatabaseCache.PATH);
        DatabaseCache.cache = DatabaseCache.readCacheFromDisk();

        Scanner scanner = new Scanner(System.in);
        System.out.println(enterANumber);
        String numberStr = scanner.nextLine();
        while (!numberStr.equals("e")) {
            try {
                int number = Integer.parseInt(numberStr);
                System.out.println("Factorial of " + number + " is " + calculator.calc(number));
                numberStr = scanner.nextLine();
            } catch (NumberFormatException e) {
                if (numberStr.equals("c")) {
                    DatabaseCache.cache.clear();  // cleans ROM cache
                    DatabaseCache.writeCacheOnDisk(DatabaseCache.cache);  // cleans disk cache
                    System.out.println("Cache is cleaned");
                    System.out.println(enterANumber);
                } else {
                    System.out.println("Wrong symbol!");
                }
                numberStr = scanner.nextLine();
            }
        }
        DatabaseCache.writeCacheOnDisk(DatabaseCache.cache);
    }
}
