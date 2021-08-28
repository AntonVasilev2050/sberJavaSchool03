package Theme04Exceptions.Task2Terminal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Theme04Exceptions.Task2Terminal.UI.wrongPinSymbols;

public class PinListener implements KeyListener {
    StringBuilder pinStr;
    int i = 0;

    public PinListener(StringBuilder pinStr) {
        this.pinStr = pinStr;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int checkIfDigit;
        try {
            checkIfDigit = Integer.parseInt(String.valueOf(e.getKeyChar()));
            pinStr.append(e.getKeyChar());
            UI.pins[i].setText(" " + e.getKeyChar() + " ");
            if (i > 2) {
                UI.frame.dispose();
            } else {
                i++;
            }
        } catch (NumberFormatException ex) {
            wrongPinSymbols();
        }
    }
}
