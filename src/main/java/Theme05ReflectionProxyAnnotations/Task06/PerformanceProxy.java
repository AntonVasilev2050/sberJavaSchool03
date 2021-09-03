package Theme05ReflectionProxyAnnotations.Task06;

import Theme05ReflectionProxyAnnotations.Task01.Calculator;
import Theme05ReflectionProxyAnnotations.Task01.CalculatorImpl;

import java.lang.reflect.Proxy;

public class PerformanceProxy {
    public static void main(String[] args) {
        Calculator delegate = new CalculatorImpl();
        Calculator calculatorProxy = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new MetricInvocationHandler(delegate));
        System.out.println(calculatorProxy.calc(3));
    }
}
