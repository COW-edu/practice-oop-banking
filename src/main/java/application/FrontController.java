package application;

import banking.ActivateAccountFunction;
import banking.BankingFunction;
import banking.DeactivateAccountFunction;
import banking.DeleteAccountFunction;
import banking.DepositFunction;
import banking.GetAccountInfoFunction;
import banking.GetInterestFunction;
import banking.CreateAccountFunction;
import banking.QuitFunction;
import banking.RemittanceFunction;
import banking.SelectMenuFunction;
import banking.WithdrawalFunction;
import controller.BankingController;
import java.util.HashMap;
import view.EMenu;
import view.InputView;
import view.OutputView;

public class FrontController {
  private final HashMap<EMenu, BankingFunction> functions = new HashMap<>();

  public FrontController(
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    functions.put(EMenu.eMakeAccount, new CreateAccountFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eDeleteAccount, new DeleteAccountFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eAccountInfo, new GetAccountInfoFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eActivateAccount, new ActivateAccountFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eDeactivateAccount, new DeactivateAccountFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eWithdrawal, new WithdrawalFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eDeposit, new DepositFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eRemittance, new RemittanceFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eInterest, new GetInterestFunction(bankingController, inputView, outputView));
    functions.put(EMenu.eQuit, new QuitFunction(bankingController, inputView, outputView));
    functions.put(null, new SelectMenuFunction(functions, bankingController, inputView, outputView));
  }

  public boolean process() {
    return functions.get(null).execute();
  }
}
