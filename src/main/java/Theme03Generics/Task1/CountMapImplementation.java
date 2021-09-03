package Theme03Generics.Task1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImplementation<K> implements CountMap<K> {
    private final Map<K, Integer> map = new HashMap<>();

    @Override
    public void add(K k) {
        Integer count = map.get(k);
        if (count == null) {
            count = 0;
        }
        map.put(k, ++count);
    }

    @Override
    public int getCount(K k) {
        return map.get(k);
    }

    @Override
    public int remove(K k) {
        return map.remove(k);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<K> source) {
        for (K key: source.toMap().keySet()){
            Integer count = map.get(key);
            if(count == null){
                count = 0;
            }
            map.put(key, source.getCount(key) + count);
        }

    }

    @Override
    public Map<K, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<K, Integer> destination) {
        for (K key : map.keySet()) {
            destination.put(key, map.get(key));
        }
    }

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImplementation<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        int count = map.getCount(5);
        System.out.println(count);
        count = map.getCount(6);
        System.out.println(count);
        count = map.getCount(10);
        System.out.println(count);
        for (Integer el : map.toMap().keySet()) {
            System.out.println(el);
        }
        map.remove(10);
        System.out.println("10 was removed");
        for (Integer el : map.toMap().keySet()) {
            System.out.println(el);
        }
    }
}


