package view;

import java.math.BigDecimal;

public interface InputView {
  public int getInt() throws NumberFormatException;

  public String getString();

  public BigDecimal getBigDecimal() throws NumberFormatException;

  public boolean getBoolean() throws NumberFormatException;
}
