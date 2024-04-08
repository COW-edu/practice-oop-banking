package exception;

import common.ErrorMessage;

public class NegativeNumberException extends Exception {

  public NegativeNumberException(ErrorMessage errorMessage) {
    super(errorMessage.getPrintMessage());
  }
}
