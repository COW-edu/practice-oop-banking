package banking;

import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import view.InputView;
import view.OutputView;

public class GetInterestFunction extends BankingFunction {

  public GetInterestFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    getInterest();
    return true;
  }

  private void getInterest() {
    try {
      outputView.print(Message.Interest.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      outputView.print(bankingController.getInterest(inputView.getString()).toString());
    } catch (NotExistAccountException exception){
      outputView.printError(exception);
    } catch (DeactivatedAccountException exception) {
      outputView.printError(exception);
    }
  }
}
