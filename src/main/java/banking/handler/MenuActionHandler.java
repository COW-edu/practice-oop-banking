package banking.handler;

import static banking.constant.MenuNumber.CREATE_ACCOUNT;
import static banking.constant.MenuNumber.DEPOSIT;
import static banking.constant.MenuNumber.EXIT;
import static banking.constant.MenuNumber.FIND_ACCOUNT;
import static banking.constant.MenuNumber.TRANSFER;
import static banking.constant.MenuNumber.WITHDRAW;

import banking.constant.MenuNumber;
import banking.controller.BankController;
import java.util.HashMap;
import java.util.Map;

public class MenuActionHandler {

  private final Map<String, Runnable> actionMap = new HashMap<>();


  public void initialize(BankController bankController) {
    actionMap.put(CREATE_ACCOUNT.getMenuNumber(), bankController::createAccount);
    actionMap.put(DEPOSIT.getMenuNumber(), bankController::depositAmountToAccount);
    actionMap.put(WITHDRAW.getMenuNumber(), bankController::withdrawAmountToAccount);
    actionMap.put(TRANSFER.getMenuNumber(), bankController::transferAmountToAccount);
    actionMap.put(FIND_ACCOUNT.getMenuNumber(), bankController::findAccountByAccountNumber);
    actionMap.put(EXIT.getMenuNumber(), bankController::exitProgram);
  }


  public boolean executeAction(MenuNumber menuNumber) {
    Runnable action = actionMap.get(menuNumber.getMenuNumber());
    if (action != null) {
      action.run();
      return true;
    }
    return false;
  }


}
