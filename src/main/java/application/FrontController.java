package application;

import controller.ActivateAccountController;
import controller.BankingController;
import controller.DeactivateAccountController;
import controller.DeleteAccountController;
import controller.DepositController;
import controller.GetAccountInfoController;
import controller.GetInterestController;
import controller.CreateAccountController;
import controller.RemittanceController;
import controller.WithdrawalController;
import common.Request;
import common.Response;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import java.util.HashMap;
import view.EMenu;

public class FrontController {
  private final HashMap<EMenu, BankingController> controllerMap = new HashMap<>();

  public FrontController() {
    controllerMap.put(EMenu.eMakeAccount, new CreateAccountController());
    controllerMap.put(EMenu.eDeleteAccount, new DeleteAccountController());
    controllerMap.put(EMenu.eAccountInfo, new GetAccountInfoController());
    controllerMap.put(EMenu.eActivateAccount, new ActivateAccountController());
    controllerMap.put(EMenu.eDeactivateAccount, new DeactivateAccountController());
    controllerMap.put(EMenu.eWithdrawal, new WithdrawalController());
    controllerMap.put(EMenu.eDeposit, new DepositController());
    controllerMap.put(EMenu.eRemittance, new RemittanceController());
    controllerMap.put(EMenu.eInterest, new GetInterestController());
  }

  public Response process(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    return controllerMap.get(request.getRequest()).process(request);
  }
}
