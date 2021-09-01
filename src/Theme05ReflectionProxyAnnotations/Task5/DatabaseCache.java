package Theme05ReflectionProxyAnnotations.Task5;

import java.io.*;
import java.util.HashMap;

public class DatabaseCache implements Serializable {
    public static HashMap<Integer, Object> cache;
    static final String PATH = "Cache.cache";
    private static final File file = new File(PATH);

    public static void createCacheOnDisk(String path) {
  // Create File
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCacheOnDisk(HashMap cache) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(cache);
            System.out.println("Cache was saved to disk");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, Object> readCacheFromDisk() {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                cache = (HashMap) objectInputStream.readObject();
            } catch (Exception e) {
                cache.put(0, 0);
                writeCacheOnDisk(cache);
            }

        return cache;
    }
}
