package Theme13JITandGC;

import java.util.HashMap;
import java.util.Map;

public class ManyObjects {
    public static void main(String[] args) {
        int number = 100000000;
        Objects[] oj = new  Objects[number];
        for (int i = 0; i < number; i++) {
            Map<Integer, String> map = new HashMap<>();
            for (int j = 0; j < 100; j++) {
                map.put(j, "new value " + j);
            }
            Objects objects = new Objects("This is a new object number " + i, i, map);
            oj[i] = objects;
        }

    }

    static class Objects {
        String field1;
        Integer integer;
        Map<Integer, String> map;

        public Objects(String field1, Integer integer, Map<Integer, String> map) {
            this.field1 = field1;
            this.integer = integer;
            this.map = map;
        }
    }
}
