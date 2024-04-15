package view;

import common.ErrorMessage;
import common.Message;
import common.RequireMessage;
import exception.DeactivatedAccountException;
import exception.IndexOutOfRangeException;
import exception.NotExistAccountException;

public interface OutputView {
  void print(String printMessage);

  void print(RequireMessage requireMessage);

  void print(Message message);

  void printError(ErrorMessage errorMessage);

  void printError(String errorMessage);
}