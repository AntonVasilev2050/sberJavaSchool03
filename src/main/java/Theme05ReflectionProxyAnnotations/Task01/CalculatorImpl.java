package Theme05ReflectionProxyAnnotations.Task01;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int result = number;
        do {
            result = result * (number - 1);
            number--;
        } while (number > 1);
        return result;
    }

    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        System.out.println(calculator.calc(13));
    }
}
