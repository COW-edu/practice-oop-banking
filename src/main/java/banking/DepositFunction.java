package banking;

import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.DeactivatedAccountException;
import exception.NegativeNumberException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import view.InputView;
import view.OutputView;

public class DepositFunction extends BankingFunction {
  public DepositFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    deposit();
    return true;
  }

  private void deposit() {
    try {
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String accountNumber = inputView.getString();
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + RequireMessage.RequireAmount.getPrintMessage());
      BigDecimal depositAmount = inputView.getBigDecimal();
      bankingController.deposit(accountNumber, depositAmount);
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + Message.Complete.getPrintMessage());
      outputView.print(bankingController.getAccountInfo(accountNumber));
    } catch (NotExistAccountException exception){
      outputView.printError(exception);
    } catch (DeactivatedAccountException exception) {
      outputView.printError(exception);
    } catch (NegativeNumberException exception) {
      outputView.printError(exception);
    }
  }
}