package Theme04Exceptions.Task2Terminal;

public class ShowMessage {
    static void wrongPinSymbols(){
        System.out.println("Вы ввели некорректные символы.");
    }

    static void wrongPinLength(){
        System.out.println("Ошибка ввода. Длинна PIN четыре цифры.");
    }

    static void waitTime(long timeToWait){
        System.out.println("Подождите: " + timeToWait + " секунд");
    }

    static void welcome(){
        System.out.println("Welcome!");
    }

    static void showBalance(double balance){
        System.out.println("На Вашем счете: " + balance);
    }

    static void wrongAmount(){
        System.out.println("Введите сумму кратную 100.");
    }

    static void notEnough(){
        System.out.println("Недостаточно средств на счете.");
    }
}
