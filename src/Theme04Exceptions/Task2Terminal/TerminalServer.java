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
                    ShowMessage.waitTime(timeToWait);
                    try {
                        Thread.currentThread().sleep(timeToWait * 1000);
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

    void deposit(int pin, double amount) {
        if (amount % 100 == 0 && amount > 0) {
            double balance = getAccountBalance(pin);
            accounts.put(pin, balance + amount);
            balance = getAccountBalance(pin);
            ShowMessage.showBalance(balance);
        } else {
            ShowMessage.wrongAmount();
        }
    }

    void withdraw(int pin, double amount) {
        if (amount % 100 == 0 && amount > 0) {
            double balance = getAccountBalance(pin);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(pin, balance);
                ShowMessage.showBalance(balance);
            } else {
                ShowMessage.notEnough();
            }
        } else {
            ShowMessage.wrongAmount();
        }
    }

    boolean tenSecsGone(long startTime) {
        if (System.currentTimeMillis() - startTime < waitFor) {
            return false;
        }
        return true;
    }
}
