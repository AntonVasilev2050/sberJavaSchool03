package Theme05ReflectionProxyAnnotations.Task01;

import Theme05ReflectionProxyAnnotations.Task5.Cache;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @Cache
    int calc (int number);

}
