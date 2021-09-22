package Theme11MultithreadingPart2;

public interface ThreadPool {
    void start();
    void execute(Runnable runnable);
}
