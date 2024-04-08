package view;

import java.math.BigDecimal;

public interface InputView {
  int getInt() throws NumberFormatException;

  String getString();

  BigDecimal getBigDecimal() throws NumberFormatException;

  boolean getBoolean() throws NumberFormatException;
}
