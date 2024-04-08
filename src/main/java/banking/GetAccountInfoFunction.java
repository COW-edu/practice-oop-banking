package banking;

import common.RequireMessage;
import controller.BankingController;
import exception.NotExistAccountException;
import view.InputView;
import view.OutputView;

public class GetAccountInfoFunction extends BankingFunction {
  public GetAccountInfoFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    getAccountInfo();
    return true;
  }

  public void getAccountInfo() {
    try {
      outputView.print(RequireMessage.RequireAccountNumber.getPrintMessage());
      outputView.print(bankingController.getAccountInfo(inputView.getString()));
    } catch (NotExistAccountException exception){
      outputView.printError(exception);
    }
  }
}
