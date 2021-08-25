package Theme04Exceptions.Task2Terminal;

import java.util.HashMap;

public class TerminalImp {
    public static void main(String[] args) {
        PinValidator pinValidator = new PinValidator();
        TerminalServer terminalServer = new TerminalServer();
        terminalServer.accounts = new HashMap<>();
        terminalServer.accounts.put(1111, 10_900.0);
        terminalServer.accounts.put(1234, 20_900.0);
        terminalServer.accounts.put(2222, 60_252.0);
        terminalServer.accounts.put(7551, 10_300.0);
        terminalServer.accounts.put(9099, 10_111.0);
        System.out.println(terminalServer.accounts);
        int pin;
        boolean accExists;
        do {
            pin = pinValidator.getPin();
            accExists = terminalServer.accountExists(pin);
            System.out.println("account exists: " + accExists);
        } while (!accExists);
        System.out.println("Welcome!");

    }
}
