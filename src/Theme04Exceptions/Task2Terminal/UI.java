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
    static JLabel[] pins = new JLabel[4];

    static void requestPin(StringBuilder pinStr) {
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


        pins[0] = new JLabel(" X ");
        pins[1] = new JLabel(" X ");
        pins[2] = new JLabel(" X ");
        pins[3] = new JLabel(" X ");
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

        frame.addKeyListener(new PinListener(pinStr));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(pinPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    static void wrongPinSymbols() {
        System.out.println("Вы ввели недопустимый символ.");
    }

    static void waitTime(long timeToWait) {
        System.out.println("Ввод заблокирован");
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

    static void userNotFound() {
        System.out.println("Пользователь на найден");
    }

}
