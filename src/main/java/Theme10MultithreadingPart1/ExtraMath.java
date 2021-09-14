package Theme10MultithreadingPart1;

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

    public static void main(String[] args) {
        long before = System.nanoTime();
        System.out.println(factorial(20));
        System.out.println(System.nanoTime() - before);
        System.out.println("_____________________");
        before = System.nanoTime();
        System.out.println(factorialRecursion(20));
        System.out.println(System.nanoTime() - before);

    }
}
