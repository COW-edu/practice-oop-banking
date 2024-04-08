package view;

import application.FrontController;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class BankingManager {
  private final FrontController bankingManager;

  public void run() {
    boolean isRunning;
    do {
      isRunning = bankingManager.process();
    } while(isRunning);
  }
}
