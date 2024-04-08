package exception;

import common.ErrorMessage;

public class MaxAccountCountException extends Exception {

  public MaxAccountCountException(ErrorMessage errorMessage) {
    super(errorMessage.getPrintMessage());
  }
}
