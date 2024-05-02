package view;

import common.ErrorMessage;
import common.Message;
import common.RequireMessage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputViewImpl implements OutputView {
  @Getter
  private static final OutputView instance = new OutputViewImpl();

  @Override
  public void print(String printMessage) {
    System.out.println(printMessage);
  }

  public void print(RequireMessage requireMessage) {
    System.out.println(requireMessage.getPrintMessage());
  }

  public void print(Message message) {
    System.out.println(message.getPrintMessage());
  }

  @Override
  public void printError(ErrorMessage errorMessage) {
    printError(errorMessage.getPrintMessage());
  }

  @Override
  public void printError(String errorMessage) {
    System.out.println("[Error] : " + errorMessage);
  }
}
