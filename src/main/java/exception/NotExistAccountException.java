package exception;

import common.ErrorMessage;
import lombok.Getter;

@Getter
public class NotExistAccountException extends Exception {
  private final String accountNumber;
  public NotExistAccountException(String errorMessage, String accountNumber) {
    super(errorMessage);
    this.accountNumber = accountNumber;
  }

  public NotExistAccountException(ErrorMessage errorMessage, String accountNumber) {
    super(errorMessage.getPrintMessage());
    this.accountNumber = accountNumber;
  }
}
