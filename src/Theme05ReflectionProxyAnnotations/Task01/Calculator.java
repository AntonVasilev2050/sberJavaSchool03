package Theme05ReflectionProxyAnnotations.Task01;

import Theme05ReflectionProxyAnnotations.Task5.Cache;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @Cache(cacheMode = 1)
    int calc (int number);

}
