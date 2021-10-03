package Theme13JITandGC;

import java.util.HashMap;
import java.util.Map;

public class JIT {

    public static void main(String[] args) {
        System.out.println("start");
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 100_000; i++) {
            map.put(i, "value" + i);
        }
        System.out.println("finish---");
    }


}
