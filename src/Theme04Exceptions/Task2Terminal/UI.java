package Theme04Exceptions.Task2Terminal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI {
    static JFrame frame;
    static JPanel topPanel;
    static JLabel enterPinLabel;

    static void requestPin(StringBuilder pinStr) {
        final int[] i = {0};
        frame = new JFrame("Terminal");
        frame.setBounds(20, 20, 200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        enterPinLabel = new JLabel("Введите PIN");
        enterPinLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(enterPinLabel);

        JPanel pinPanel = new JPanel();
        pinPanel.setLayout(new GridBagLayout());

        JLabel[] pins = {
                new JLabel(" X "),
                new JLabel(" X "),
                new JLabel(" X "),
                new JLabel(" X ")};
        pins[0].setFont(new Font("Arial", Font.BOLD, 22));
        pins[1].setFont(new Font("Arial", Font.BOLD, 22));
        pins[2].setFont(new Font("Arial", Font.BOLD, 22));
        pins[3].setFont(new Font("Arial", Font.BOLD, 22));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        pinPanel.add(pins[0], c);
        c.gridx = 1;
        pinPanel.add(pins[1], c);
        c.gridx = 2;
        pinPanel.add(pins[2], c);
        c.gridx = 3;
        pinPanel.add(pins[3], c);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int digit;
                try {
                    digit = Integer.parseInt(String.valueOf(e.getKeyChar()));
                    pinStr.append(e.getKeyChar());
                    if (i[0] > 2) {
                        frame.dispose();
                    } else {
                        pins[i[0]].setText(" " + e.getKeyChar() + " ");
                        i[0]++;
                    }
                } catch (NumberFormatException ex) {
                    wrongPinSymbols();
                }
            }
        });

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(pinPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    static void wrongPinSymbols() {
        System.out.println("Вы ввели недопустимый символ.");
    }

    static void wrongPinLength() {
        System.out.println("Ошибка ввода. Длинна PIN четыре цифры.");
    }

    static void waitTime(long timeToWait) {
        System.out.println("Подождите: " + timeToWait + " секунд");
    }

    static void welcome() {
        System.out.println("Welcome!");
    }

    static void showBalance(double balance) {
        System.out.println("На Вашем счете: " + balance);
    }

    static void wrongAmount() {
        System.out.println("Введите сумму кратную 100.");
    }

    static void notEnough() {
        System.out.println("Недостаточно средств на счете.");
    }

    static void userNotFound(){
        System.out.println("Пользователь на найден");
    }

}
