package banking;

import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import view.InputView;
import view.OutputView;

public class DeactivateAccountFunction extends BankingFunction {

  public DeactivateAccountFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    deactivate();
    return true;
  }

  private void deactivate() {
    try{
      outputView.print(Message.Deactivate.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      bankingController.deactivateAccount(inputView.getString());
      outputView.print(Message.Deactivate.getPrintMessage() + " "
          + Message.Complete.getPrintMessage());
    } catch (NotExistAccountException | DeactivatedAccountException exception){
      outputView.printError(exception.getMessage());
    }
  }
}
