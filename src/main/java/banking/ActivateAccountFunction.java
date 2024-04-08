package banking;

import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.NotExistAccountException;
import view.InputView;
import view.OutputView;

public class ActivateAccountFunction extends BankingFunction {
  public ActivateAccountFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    activateAccount();
    return true;
  }

  public void activateAccount() {
    try{
      outputView.print(Message.Activate.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      bankingController.activateAccount(inputView.getString());
      outputView.print(Message.Activate.getPrintMessage() + Message.Complete.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(exception);
    }
  }
}
