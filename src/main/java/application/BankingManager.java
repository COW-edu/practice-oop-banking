package application;

import common.EParamType;
import common.Request;
import common.Response;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import java.util.HashMap;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import view.EMenu;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class BankingManager {
  private final FrontController frontController;

  public Response makeAccount(HashMap<EParamType, Object> params)
      throws NotExistAccountException, DeactivatedAccountException {
    Request request = new Request(EMenu.eMakeAccount, params);
    return frontController.process(request);
  }

  public Response deleteAccount(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = new HashMap<>();
    params.put(EParamType.eAccountNumber, accountNumber);
    Request request = new Request(EMenu.eDeleteAccount, params);
    return frontController.process(request);
  }

  public Response activateAccount(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = new HashMap<>();
    params.put(EParamType.eAccountNumber, accountNumber);
    Request request = new Request(EMenu.eActivateAccount, params);
    return frontController.process(request);
  }

  public Response deactivateAccount(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = new HashMap<>();
    params.put(EParamType.eAccountNumber, accountNumber);
    Request request = new Request(EMenu.eDeactivateAccount, params);
    return frontController.process(request);
  }

  public Response getAccount(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
      HashMap<EParamType, Object> params = new HashMap<>();
      params.put(EParamType.eAccountNumber, accountNumber);
      Request request = new Request(EMenu.eAccountInfo, params);
      return frontController.process(request);
  }

  public Response getInterest(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
      HashMap<EParamType, Object> params = new HashMap<>();
      params.put(EParamType.eAccountNumber, accountNumber);
      Request request = new Request(EMenu.eInterest, params);
      return frontController.process(request);
  }

  public Response remittance(String withDrawalAccountNumber, String depositAccountNumber, BigDecimal amount)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = new HashMap<>();
    params.put(EParamType.eWithdrawalAccountNumber, withDrawalAccountNumber);
    params.put(EParamType.eDepositAccountNumber, depositAccountNumber);
    params.put(EParamType.eAmount, amount);
    Request request = new Request(EMenu.eRemittance, params);
    return frontController.process(request);
  }

  public Response deposit(String accountNumber, BigDecimal depositAmount)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = new HashMap<>();
    params.put(EParamType.eAccountNumber, accountNumber);
    params.put(EParamType.eAmount, depositAmount);
    Request request = new Request(EMenu.eDeposit, params);
    return frontController.process(request);
  }

  public Response withdrawal(String accountNumber, BigDecimal withdrawalAmount)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = new HashMap<>();
    params.put(EParamType.eAccountNumber, accountNumber);
    params.put(EParamType.eAmount, withdrawalAmount);
    Request request = new Request(EMenu.eWithdrawal, params);
    return frontController.process(request);
  }
}
