package Theme05ReflectionProxyAnnotations.Task04;

import java.lang.reflect.Field;

//Задача 4:
//Проверить что все String константы имеют значение = их имени
//public static final String MONDAY = "MONDAY";
public class FinalStrings {
    public static boolean check(Object o) throws IllegalAccessException {
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields){
            String type = String.valueOf(field.getType());
            if(type.equals("class java.lang.String")){
                String name = field.getName();
                String value = (String) field.get(o);
                if(!name.equals(value)){
                    System.out.println("The name of field '" + name + "' doesn't equal to its value - '" + value + "'");
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Week week = new Week();
        try {
            System.out.println(check(week));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
