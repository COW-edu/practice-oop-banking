package banking;

import common.Message;
import controller.BankingController;
import view.InputView;
import view.OutputView;

public class QuitFunction extends BankingFunction {

  public QuitFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    outputView.print(Message.Exit);
    return false;
  }
}
