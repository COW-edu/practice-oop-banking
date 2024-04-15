package view;

import java.math.BigDecimal;
import java.util.Scanner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputViewImpl implements InputView {
  private final Scanner scanner = new Scanner(System.in);

  @Getter
  private static final InputView instance = new InputViewImpl();

  @Override
  public int getInt() throws NumberFormatException{
    return scanner.nextInt();
  }

  @Override
  public String getString(){
    return scanner.next();
  }

  @Override
  public BigDecimal getBigDecimal() throws NumberFormatException {
    return new BigDecimal(scanner.next());
  }

  @Override
  public boolean getBoolean() throws NumberFormatException{
    int input = scanner.nextInt();
    if (input == 0) {
      return false;
    } else if (input == 1) {
      return true;
    } else {
      throw new NumberFormatException("0 또는 1만 입력해주세요.");
    }
  }
}
