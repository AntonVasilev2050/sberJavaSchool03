package Theme08Serialization;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CacheInvocationHandler implements InvocationHandler {
    Object delegate;
    Cache annotation;
    String fileNamePrefix;
    boolean zip;
    int cacheType;
    private final int IN_MEMORY = 0;
    private final int FILE = 1;

    public CacheInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }
        List<Object> keyList = new ArrayList<>(Arrays.asList(args));
        annotation = method.getAnnotation(Cache.class);
        fileNamePrefix = annotation.fileNamePrefix();
        zip = annotation.zip();
        if (zip) {
            fileNamePrefix = fileNamePrefix + ".zip";
//            DatabaseCache.createCacheOnDisk(DatabaseCache.path, fileNamePrefix);
            DatabaseCache.cache = DatabaseCache.readCacheFromDiskZip(fileNamePrefix);
        } else {
            fileNamePrefix = fileNamePrefix + ".cache";
//            DatabaseCache.createCacheOnDisk(DatabaseCache.path, fileNamePrefix);
            DatabaseCache.cache = DatabaseCache.readCacheFromDisk(fileNamePrefix);
        }
        if (!annotation.accountableParameter().equals("all")) {
            try {
                int accountableParameter = Integer.parseInt(annotation.accountableParameter());
                for (int i = 0; i < keyList.size(); i++) {
                    if (i != accountableParameter) {
                        keyList.set(i, null);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Cache accountable parameter should be a digit or 'all'");
            }
        }
        System.out.println("keyList = " + keyList);
        if (DatabaseCache.cache.containsKey(keyList)) {
            System.out.println("returns from cache");
            return DatabaseCache.cache.get(keyList);
        } else {
            Object invoke = method.invoke(delegate, args);
            DatabaseCache.cache.put(keyList, invoke);
            cacheType = annotation.cacheType();
            if (cacheType == FILE) {
                if (zip) {
                    DatabaseCache.writeCacheOnDiskZip(DatabaseCache.cache, fileNamePrefix);
                } else {
                    DatabaseCache.writeCacheOnDisk(DatabaseCache.cache, fileNamePrefix);
                }
            }
            return invoke;
        }
    }
}
