package banking;

import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.NotExistAccountException;
import view.InputView;
import view.OutputView;

public class DeleteAccountFunction extends BankingFunction {
  public DeleteAccountFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    deleteAccount();
    return true;
  }

  private void deleteAccount() {
    try{
      outputView.print(Message.Delete.getPrintMessage() + " " +
          RequireMessage.RequireAccountNumber.getPrintMessage());
      bankingController.deleteAccount(inputView.getString());
      outputView.print(Message.Delete.getPrintMessage() + " "
          + Message.Complete.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(exception);
    }
  }
}
