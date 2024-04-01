package exception.system;

public class NotFoundAccountException extends Exception {
    public NotFoundAccountException(String message) {
      super(message);
    }
  }