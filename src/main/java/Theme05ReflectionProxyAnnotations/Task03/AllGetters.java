package Theme05ReflectionProxyAnnotations.Task03;

import Theme02.Task0.Car;

import java.lang.reflect.Method;

public class AllGetters {
// Задача 3:
//Вывести все геттеры класса
    public static void print(Object o){
        Class<?> aClass = o.getClass();
//        Method[] methods = aClass.getMethods();
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method method: methods1){
            String methodStr = method.getName();
            if(methodStr.startsWith("get")){
                System.out.println(methodStr);
            }
        }
    }

    public static void main(String[] args) {
        Car car = new Car("bmv", "sedan");
        AllGetters.print(car);
    }
}
