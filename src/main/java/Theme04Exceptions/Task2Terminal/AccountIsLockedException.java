package Theme04Exceptions.Task2Terminal;

public class AccountIsLockedException extends Exception{
    long waitFor = 10_000;
    AccountIsLockedException(long startTime){
        long timeToWait = (waitFor - (System.currentTimeMillis() - startTime)) / 1000;
        UI.waitTime(timeToWait);
    }

}
