package Theme12JavaMemoryModel.Task01;


import java.util.concurrent.*;

public class Task<T> {
    private final Callable<?> callable;
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

//    public  T get()  {
//        Future<T> future;
//        future =  executorService.submit(new Task<T>( callable));
//        return (T) future;
//    }

    public static void main(String[] args) {
    }
}
