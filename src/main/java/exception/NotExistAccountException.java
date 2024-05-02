package exception;

import common.Message;
import lombok.Getter;

@Getter
public class NotExistAccountException extends Exception {
  private final String accountNumber;
  public NotExistAccountException(String errorMessage, String accountNumber) {
    super(errorMessage);
    this.accountNumber = accountNumber;
  }

  public NotExistAccountException(Message errorMessage, String accountNumber) {
    super(errorMessage.getPrintMessage());
    this.accountNumber = accountNumber;
  }
}
