package Theme10MultithreadingPart1;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ExtraMath {
    public static double factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        double result = number;
        do {
            result = result * (number - 1);
            number--;
        } while (number > 1);
        return result;
    }

    public static double factorialRecursion(double number){
        if (number <= 1) return  1;
        else return number * factorialRecursion(number - 1);
    }

    public static long factorialLongStream(int number){
        long factorial;
        return factorial = LongStream.rangeClosed(1, number).parallel().reduce((a, b) -> a * b).getAsLong();
    }

    public static BigInteger factorialBigInteger(int number){
        BigInteger factorial;
        return factorial =  IntStream.rangeClosed(1, number)
                .parallel()
                .mapToObj(String::valueOf)
                .map(BigInteger::new)
                .reduce((a, b) -> a.multiply(b))
                .get();
    }

    public static void main(String[] args) {
        long before = System.nanoTime();
        System.out.println(factorialBigInteger(50));
        System.out.println(System.nanoTime() - before);
        System.out.println("_____________________");

        before = System.nanoTime();
        System.out.println(factorialLongStream(50));
        System.out.println(System.nanoTime() - before);
        System.out.println("_____________________");

        before = System.nanoTime();
        System.out.println(factorialRecursion(50));
        System.out.println(System.nanoTime() - before);

    }
}
