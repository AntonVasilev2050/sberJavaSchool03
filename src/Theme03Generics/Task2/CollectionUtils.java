package Theme03Generics.Task2;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new <T>ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static <T> void add(List<T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<T> c2) {
        for (T t : c2) {
            if (c1.contains(t)) {
                return true;
            }
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> result = newArrayList();
        for (T t : list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0) {
                result.add(t);
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }


    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> result = newArrayList();
        for (T t : list) {
            if (comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0) {
                result.add(t);
            }
        }
        result.sort(comparator);
        return result;
    }

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
        System.out.println(limit(list, 3));
        System.out.println(list);
        removeAll(list, listFirst);
        System.out.println(list);

        System.out.println(containsAny(listFirst, list));
        add(list, "3");
        System.out.println(containsAny(listFirst, list));
        list.remove("3");
        System.out.println(containsAny(listFirst, list));
        System.out.println(range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6));
        System.out.println(range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6, Comparator.naturalOrder()));
    }

}

