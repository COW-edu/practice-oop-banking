package application;

import view.BankingView;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public class AppConfig {

  public BankingView banking() {
    return new BankingView(bankingManager(), inputView(), outputView());
  }
  private BankingManager bankingManager() {
    return new BankingManager(frontController());
  }

  private FrontController frontController() {
    return new FrontController();
  }

  private InputView inputView() {
    return InputViewImpl.getInstance();
  }

  private OutputView outputView() {
    return OutputViewImpl.getInstance();
  }
}
