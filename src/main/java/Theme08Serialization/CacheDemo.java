package main.java.Theme08Serialization;


import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class CacheDemo {
    private final static String askItemName = "Enter a symbol or a number: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a method: ");
        System.out.println("1 - 'run'");
        System.out.println("2 - 'work'");
        System.out.println("3 - 'factorial'");
        System.out.println("or type 'e' to exit");
        String methodName = scanner.nextLine();
        while (!methodName.equals("e")) {
            try {
                int methodNumber = Integer.parseInt(methodName);
                switch (methodNumber) {
                    case 1:
                        cache("run");
                        break;
                    case 2:
                        cache("work");
                        break;
                    case 3:
                        cache("factorial");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong symbol.");
            }
            methodName = scanner.nextLine();
        }
    }

    public static void cache(String methodToImplement) {
        Theme08Serialization.Service delegate = new Theme08Serialization.ServiceImp();
        Theme08Serialization.Service service = (Theme08Serialization.Service) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new Theme08Serialization.CacheInvocationHandler(delegate));

        Theme08Serialization.DatabaseCache.cache = new ConcurrentHashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(methodToImplement);
        System.out.println(askItemName);
        String itemName = scanner.nextLine();
        while (!itemName.equals("e")) {
            if (itemName.equals("c")) {
                cacheClear();
            } else {
                switch (methodToImplement) {
                    case "run":
                        List<String> run = service.run(itemName, Math.random(), new Date());
                        System.out.println("list calculated by 'run' " + run.hashCode());
                        break;
                    case "work":
                        List<String> work = service.work(itemName);
                        System.out.println("list calculated by 'work' " + work.hashCode());
                        break;
                    case "factorial":
                        int itemNumber = 0;
                        try {
                            itemNumber = Integer.parseInt(itemName);
                            int factorial = service.factorial(itemNumber);
                            System.out.println("Factorial of " + itemNumber + " is " + factorial);
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a number 1..14");
                        }
                        break;
                }
            }
            itemName = scanner.nextLine();
        }
        System.exit(0);

    }

    public static void cacheClear() {
        Theme08Serialization.DatabaseCache.cache.clear();  // cleans ROM cache
//        DatabaseCache.writeCacheOnDisk(DatabaseCache.cache);  // cleans disk cache
        System.out.println("Cache was cleaned");
        System.out.println(askItemName);
    }

}


