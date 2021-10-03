package theme14concurrent;

import java.io.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DatabaseCache {
    public static ConcurrentHashMap<List<Object>, Object> cache;
    public static String path = "C://temp/";
    private static File file;

    public static void createCacheOnDisk(String path, String fileNamePrefix) {
        // Create File
        try {
            file = new File(path);
            file.mkdirs();
            file = new File(path + fileNamePrefix);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void writeCacheOnDisk(ConcurrentHashMap<List<Object>, Object> cache, String fileNamePrefix) {
//        file = new File(path + fileNamePrefix + ".cache");
        String cachePath = path + fileNamePrefix;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(cachePath))) {
            objectOutputStream.writeObject(cache);
            System.out.println("Cache was saved to the disk");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void writeCacheOnDiskZip(ConcurrentHashMap<List<Object>, Object> cache, String fileNamePrefix) {
        String zipPath = path + fileNamePrefix;
        try (GZIPOutputStream zipOutputStream = new GZIPOutputStream(new FileOutputStream(zipPath));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(zipOutputStream)) {
            objectOutputStream.writeObject(cache);
            System.out.println("Cache was saved to the disk as zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static ConcurrentHashMap<List<Object>, Object> readCacheFromDisk(String fileNamePrefix) {
//        file = new File(path + fileNamePrefix + ".cache");
        String cachePath = path + fileNamePrefix;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(cachePath))) {
            cache = (ConcurrentHashMap<List<Object>, Object>) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("Can't read from " + cachePath);
        }
        return cache;
    }


    public synchronized static ConcurrentHashMap<List<Object>, Object> readCacheFromDiskZip(String fileNamePrefix) {
        String cachePath = path + fileNamePrefix;
        try (GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(cachePath));
             ObjectInputStream objectInputStream = new ObjectInputStream(gzipInputStream)) {
            cache = (ConcurrentHashMap<List<Object>, Object>) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("Can't read from " + cachePath);
        }
        return cache;
    }
}
