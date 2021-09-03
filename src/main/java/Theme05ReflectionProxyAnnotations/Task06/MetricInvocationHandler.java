package Theme05ReflectionProxyAnnotations.Task06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MetricInvocationHandler implements InvocationHandler {
    Object delegate;
    public MetricInvocationHandler(Object delegate){
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!method.isAnnotationPresent(Metric.class)){
            return method.invoke(delegate, args);
        }
        long before = System.nanoTime();
        Object invoke = method.invoke(delegate, args);
        long after = System.nanoTime();
        System.out.println("It took " + (after - before) + " nanoSec  to execute the method");
        return invoke;
    }
}
