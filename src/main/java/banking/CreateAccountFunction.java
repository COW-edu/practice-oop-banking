package banking;

import account.AccountType;
import common.Message;
import common.RequireMessage;
import controller.BankingController;
import exception.IndexOutOfRangeException;
import exception.MaxAccountCountException;
import exception.NegativeNumberException;
import java.math.BigDecimal;
import java.util.Optional;
import util.AccountUtil;
import view.InputView;
import view.OutputView;

public class CreateAccountFunction extends BankingFunction {
  public CreateAccountFunction(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
  }

  @Override
  public boolean execute() {
    makeAccount();
    return true;
  }

  private void makeAccount() {
    try {
      outputView.print(RequireMessage.RequireAccountType);
      AccountType accountType =
          AccountUtil.intToAccountType(inputView.getInt());
      outputView.print(RequireMessage.RequireOwner);
      String owner = inputView.getString();
      outputView.print(RequireMessage.RequireActivation);
      boolean activation = inputView.getBoolean();
      String accountInfo = null;
      switch (accountType) {
        case BASIC_ACCOUNT -> {
          accountInfo = bankingController.createAccount(accountType, owner, activation);
        }
        case SAVING_ACCOUNT -> {
          outputView.print(Message.Target.getPrintMessage() + " " +
              RequireMessage.RequireAmount.getPrintMessage());
          BigDecimal targetAmount = inputView.getBigDecimal();
          accountInfo =
              bankingController.createAccount(accountType, owner, targetAmount, activation);
        }
      }
      accountInfo = Optional.ofNullable(accountInfo)
          .orElse(Message.AccountCreationFailed.getPrintMessage());
      outputView.print(accountInfo);
    } catch (IndexOutOfRangeException exception) {
      outputView.printError(exception);
    } catch (MaxAccountCountException exception) {
      outputView.printError(exception);
    } catch (NegativeNumberException exception) {
      outputView.printError(exception);
    }
  }
}
