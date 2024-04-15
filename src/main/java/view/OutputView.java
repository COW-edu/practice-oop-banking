package view;

import common.ErrorMessage;
import common.Message;
import common.RequireMessage;

public interface OutputView {
  void print(String printMessage);

  void print(RequireMessage requireMessage);

  void print(Message message);

  void printError(ErrorMessage errorMessage);

  void printError(String errorMessage);
}