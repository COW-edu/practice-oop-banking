package banking.exception;

public class InsufficientAmount extends RuntimeException{
    public InsufficientAmount(String message) {
        super(message);
    }
}