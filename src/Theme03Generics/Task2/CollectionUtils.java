package Theme03Generics.Task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new <T>ArrayList<T>();
    }

    public static <T> int indexOf(List<T> source, T t) {
        return source.indexOf(t);
    }

    public static <T>List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static <T> void add(List <T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

//    public static boolean containsAll(List c1, List c2) {
//    }
//
//    public static boolean containsAny(List c1, List c2) {
//    }
//
//    public static List range(List list, Object min, Object max) {
//    }
//
//    public static List range(List list, Object min, Object max, Comparator comparator) {
//    }

    public static void main(String[] args) {
        List<String> listFirst = newArrayList();
        listFirst.add("1");
        listFirst.add("2");
        listFirst.add("3");
        listFirst.add("4");
        listFirst.add("5");
        listFirst.add("6");
        System.out.println(listFirst);

        List<String> list = newArrayList();
        addAll(listFirst, list);
        System.out.println(list);

        add(list, "77");
        add(list, "88");
        add(list, "99");
        System.out.println(list);

        System.out.println(indexOf(list, "77"));
        System.out.println(limit(list,3));
        System.out.println(list);
        removeAll(list, listFirst);
        System.out.println(list);
    }
}

