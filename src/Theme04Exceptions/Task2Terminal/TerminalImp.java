package Theme04Exceptions.Task2Terminal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TerminalImp {
    public static void main(String[] args) {
        PinValidator pinValidator = new PinValidator();
        TerminalServer terminalServer = new TerminalServer();
        StringBuilder pinStr = new StringBuilder();
        int pin;
        boolean accExists;

        User.add(new User("Anton", 1111, 100_000));
        User.add(new User("Tim", 1234, 100_000));
        User.add(new User("Sergey", 2233, 100_000));
        User.add(new User("Nikolay", 3288, 100_000));
        User.add(new User("Ivan", 8857, 100_000));
        User.add(new User("Alex", 90, 100_000));
        System.out.println(User.getUsers());
        do{
            UI.requestPin(pinStr);
            while (UI.frame.isShowing()) {
                UI.frame.getFocusOwner();
            }
            pin = Integer.parseInt(pinStr.toString());
            pinStr.delete(0,4);
            System.out.println(pin);
            accExists = terminalServer.accountExists(pin);
            System.out.println("account exists: " + accExists);
        }while (!accExists);
        UI.welcome();
        System.out.println(terminalServer.getAccountBalance(pin));
        terminalServer.deposit(pin, 300);
        terminalServer.withdraw(pin, 1000);
    }
}
