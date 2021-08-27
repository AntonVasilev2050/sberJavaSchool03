package Theme04Exceptions.Task2Terminal;

import java.util.ArrayList;

public class TerminalServer {
    ArrayList<User> users = User.getUsers();
    int attempt = 1;
    boolean isBlocked = false;
    long startTime = 0;
    long waitFor = 10_000;

    boolean accountExists(int pin) {
        System.out.println("attempt: " + attempt);
        if (attempt <= 3 && !isBlocked) {
            attempt++;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getPin() == pin) {
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
                    UI.waitTime(timeToWait);
                }
            }
        }
        return false;
    }

    double getAccountBalance(int pin) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPin() == pin) {
                return users.get(i).getBalance();
            }
        }
        UI.userNotFound();
        return 0;
    }

    void deposit(int pin, double amount) {
        double balance;
        if (amount % 100 == 0 && amount > 0) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getPin() == pin) {
                    balance = users.get(i).getBalance();
                    users.get(i).setBalance(balance + amount);
                }
            }
            User.setUsers(users);
            balance = getAccountBalance(pin);
            UI.showBalance(balance);
        } else {
            UI.wrongAmount();
        }
    }

    void withdraw(int pin, double amount) {
        double balance;
        if (amount % 100 == 0 && amount > 0) {
            balance = getAccountBalance(pin);
            if (balance >= amount) {
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getPin() == pin) {
                        users.get(i).setBalance(balance - amount);
                    }
                }
                User.setUsers(users);
                balance = getAccountBalance(pin);
                UI.showBalance(balance);
            } else {
                UI.notEnough();
            }
        } else {
            UI.wrongAmount();
        }
    }

    boolean tenSecsGone(long startTime) {
        if (System.currentTimeMillis() - startTime < waitFor) {
            return false;
        }
        return true;
    }
}
