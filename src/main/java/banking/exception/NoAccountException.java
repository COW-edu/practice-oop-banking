package banking.exception;

public class NoAccountException extends RuntimeException{
    public NoAccountException(String message) {
        super(message);
    }
}
