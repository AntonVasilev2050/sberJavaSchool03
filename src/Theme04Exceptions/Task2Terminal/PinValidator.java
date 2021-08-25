package Theme04Exceptions.Task2Terminal;

import java.util.Scanner;

public class PinValidator {
    private int pin;

    public int getPin() {
        pin = 0;
        String s;
        Scanner scanner = new Scanner(System.in);
        ShowMessage message = new ShowMessage();
        s = scanner.nextLine();
        while (s.length() != 4) {
            message.wrongPinLength();
            s = scanner.nextLine();
        }
        try {
            pin = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            message.wrongPinSymbols();
        }
//        scanner.close();
        return pin;
    }


}
