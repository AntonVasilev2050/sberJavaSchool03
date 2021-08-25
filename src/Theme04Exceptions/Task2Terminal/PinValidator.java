package Theme04Exceptions.Task2Terminal;

import java.util.Scanner;

public class PinValidator {
    private int pin;

    public int getPin() {
        pin = 0;
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        while (s.length() != 4) {
            ShowMessage.wrongPinLength();
            s = scanner.nextLine();
        }
        try {
            pin = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            ShowMessage.wrongPinSymbols();
        }
//        scanner.close();
        return pin;
    }


}
