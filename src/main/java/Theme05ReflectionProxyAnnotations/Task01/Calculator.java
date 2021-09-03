package Theme05ReflectionProxyAnnotations.Task01;

import Theme05ReflectionProxyAnnotations.Task06.Metric;
import Theme05ReflectionProxyAnnotations.Task5.Cache;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @Cache(cacheMode = 1)
    @Metric
    int calc (int number);

}
