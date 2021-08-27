package Theme04Exceptions.Task2Terminal;

import java.util.ArrayList;

public class User {
    private String name;
    private int pin;
    private double balance;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public static void add(User user){
        users.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }
}
