package banking;

import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.DeactivatedAccountException;
import exception.NegativeNumberException;
import exception.NotEnoughBalanceException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import view.InputView;
import view.OutputView;

public class WithdrawalFunction extends BankingFunction {

  public WithdrawalFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    withdrawal();
    return true;
  }

  private void withdrawal() {
    try {
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String accountNumber = inputView.getString();
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + RequireMessage.RequireAmount.getPrintMessage());
      BigDecimal withdrawalAmount = inputView.getBigDecimal();
      bankingController.withdrawal(accountNumber, withdrawalAmount);
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + Message.Complete.getPrintMessage());
      outputView.print(bankingController.getAccountInfo(accountNumber));
    } catch (NotExistAccountException exception){
      outputView.printError(exception);
    } catch (NotEnoughBalanceException exception){
      outputView.printError(exception);
    } catch (DeactivatedAccountException exception) {
      outputView.printError(exception);
    } catch (NegativeNumberException exception) {
      outputView.printError(exception);
    }
  }
}
