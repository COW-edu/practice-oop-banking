package view;

import common.ErrorMessage;
import common.Message;
import common.RequireMessage;
import exception.DeactivatedAccountException;
import exception.IndexOutOfRangeException;
import exception.MaxAccountCountException;
import exception.NegativeNumberException;
import exception.NotEnoughBalanceException;
import exception.NotExistAccountException;

public interface OutputView {
  void print(String printMessage);

  void print(RequireMessage requireMessage);

  void print(Message message);

  void printError(NumberFormatException exception);

  void printError(NotExistAccountException exception);

  void printError(IndexOutOfRangeException exception);

  void printError(MaxAccountCountException exception);

  void printError(DeactivatedAccountException exception);

  void printError(NotEnoughBalanceException exception);

  void printError(ErrorMessage errorMessage);

  void printError(String errorMessage);

  void printError(NegativeNumberException exception);
}