package Theme05ReflectionProxyAnnotations.Task02;

import Theme02.Task0.Car;

import java.lang.reflect.Method;

public class AllMethods {
    public static void print(Object o){
        Class<?> aClass = o.getClass();
        while (aClass != null) {
            Method[] declaredMethods = aClass.getDeclaredMethods();
            System.out.println("Methods of " + aClass);
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                System.out.println(method);
            }
            aClass = aClass.getSuperclass();
        }
    }

    public static void main(String[] args) {
        Car car = new Car("aaa", "bbb");
        print(car);
    }
}
