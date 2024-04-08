package exception;

import common.ErrorMessage;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class IndexOutOfRangeException extends Exception{
  private final int minIndex;
  private final int maxIndex;
  private final int inputIndex;

  public IndexOutOfRangeException(ErrorMessage errorMessage, int minIndex, int maxIndex, int inputIndex) {
    super(errorMessage.getPrintMessage());
    this.minIndex = minIndex;
    this.maxIndex = maxIndex;
    this.inputIndex = inputIndex;
  }
}
