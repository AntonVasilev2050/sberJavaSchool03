package Theme05ReflectionProxyAnnotations.Task01;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CalculatorImplTest {

    @Test
    public void calc() {
        Calculator calculator = Mockito.mock(CalculatorImpl.class);
        Mockito.when(calculator.calc(7)).thenReturn(1);

        int factorialReal = new CalculatorImpl().calc(7);
        int factorialMockito = calculator.calc(7);

        assertEquals(5040, factorialReal);
        assertEquals(1, factorialMockito);
    }
}