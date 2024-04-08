package application;

import controller.BankingController;
import controller.BankingControllerImpl;
import view.BankingManager;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public class AppConfig {

  public BankingManager banking() {
    return new BankingManager(frontController());
  }

  private FrontController frontController() {
    return new FrontController(
        bankingController(), inputView(), outputView());
  }

  private InputView inputView() {
    return InputViewImpl.getInstance();
  }

  private OutputView outputView() {
    return OutputViewImpl.getInstance();
  }

  private BankingController bankingController() {
    return new BankingControllerImpl();
  }
}
