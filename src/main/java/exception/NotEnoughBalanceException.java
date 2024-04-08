package exception;

import common.ErrorMessage;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class NotEnoughBalanceException extends Exception {

  private final BigDecimal balance;
  public NotEnoughBalanceException(ErrorMessage errorMessage, BigDecimal balance) {
    super(errorMessage.getPrintMessage());
    this.balance = balance;
  }
}
