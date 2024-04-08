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

public class RemittanceFunction extends BankingFunction {

  public RemittanceFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    remittance();
    return true;
  }

  private void remittance() {
    try {
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String withDrawalAccountNumber = inputView.getString();
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String depositAccountNumber = inputView.getString();
      outputView.print(Message.Remittance.getPrintMessage() + " "
          + RequireMessage.RequireAmount.getPrintMessage());
      BigDecimal withdrawalAmount = inputView.getBigDecimal();
      bankingController.remittance(withDrawalAccountNumber, depositAccountNumber, withdrawalAmount);
      outputView.print(Message.Remittance.getPrintMessage() + " "
          + Message.Complete.getPrintMessage());
      outputView.print(bankingController.getAccountInfo(depositAccountNumber));
      outputView.print(bankingController.getAccountInfo(withDrawalAccountNumber));
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
