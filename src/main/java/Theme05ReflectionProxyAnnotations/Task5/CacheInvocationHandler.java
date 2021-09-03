package Theme05ReflectionProxyAnnotations.Task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CacheInvocationHandler implements InvocationHandler {
    private static final int saveNone = 0;
    private static final int saveEvery = 1;
    Object delegate;

    public CacheInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }
//        System.out.println("Method " + method.getName() + " is invoked");
//        List<Object> keys = new ArrayList<>(Arrays.asList(args));
//        keys.add(method);
        Integer key = Integer.parseInt(String.valueOf(args[0]));
        if (DatabaseCache.cache.containsKey(key)) {
            System.out.println("returns cached");
            return DatabaseCache.cache.get(key);
        } else {
            Object invoke = method.invoke(delegate, args);
            DatabaseCache.cache.put(key, invoke);
            System.out.println("calculated");
            Cache annotation = method.getAnnotation(Cache.class);
            int cacheMode = annotation.cacheMode();
            if (cacheMode == saveEvery) {
                DatabaseCache.writeCacheOnDisk(DatabaseCache.cache);
            }
            return invoke;
        }
    }
}
