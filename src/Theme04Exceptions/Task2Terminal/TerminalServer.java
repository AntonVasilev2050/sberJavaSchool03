package Theme04Exceptions.Task2Terminal;

import java.util.Map;

public class TerminalServer {
    Map<Integer, Double> accounts;
    int attempt = 1;
    boolean isBlocked = false;
    long startTime = 0;
    long waitFor = 10_000;

    boolean accountExists(int pin) {
        System.out.println("attempt: " + attempt);
        if (attempt <= 3 && !isBlocked) {
            attempt++;
            for (Integer a : accounts.keySet()) {
                if (a == pin) {
                    attempt = 0;
                    return true;
                }
            }
        } else {
            if (attempt > 3) {
                attempt = 1;
                isBlocked = true;
                startTime = System.currentTimeMillis();
                System.out.println("blocked");
            }
            if (isBlocked) {
                if (tenSecsGone(startTime)) {
                    isBlocked = false;
                }
                if (!tenSecsGone(startTime)) {
                    long timeToWait = (waitFor - (System.currentTimeMillis() - startTime)) / 1000;
                    System.out.println("Подождите: " + timeToWait + " секунд");
                    try {
                        Thread.currentThread().sleep(timeToWait);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    double getAccountBalance(int pin) {
        return accounts.get(pin);

    }

    boolean tenSecsGone(long startTime) {
        if (System.currentTimeMillis() - startTime < waitFor) {
            return false;
        }
        return true;
    }
}
