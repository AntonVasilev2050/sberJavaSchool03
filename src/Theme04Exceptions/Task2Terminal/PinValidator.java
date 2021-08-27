package Theme04Exceptions.Task2Terminal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class PinValidator {
    private int pin;

    public int getPin() {
        pin = 0;
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        while (s.length() != 4) {
            UI.wrongPinLength();
            s = scanner.nextLine();
        }
        try {
            pin = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            UI.wrongPinSymbols();
        }
        return pin;
    }


}
