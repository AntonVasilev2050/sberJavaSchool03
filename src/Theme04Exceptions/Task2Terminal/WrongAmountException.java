package Theme04Exceptions.Task2Terminal;

public class WrongAmountException extends Exception{
    WrongAmountException(){
        UI.wrongAmount();
    }
}
