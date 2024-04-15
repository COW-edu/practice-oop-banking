package controller;

import account.Account;
import common.EParamType;
import common.ErrorMessage;
import common.Message;
import common.Request;
import common.Response;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;
import service.AccountService;
import service.AccountServiceImpl;

public class DepositController implements BankingController {
  AccountService accountService = AccountServiceImpl.getInstance();

  @Override
  public Response process(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    return deposit(request);
  }

  private Response deposit(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    HashMap<EParamType, Object> params = request.getParams();
    String accountNumber = (String) params.get(EParamType.eAccountNumber);
    BigDecimal amount = (BigDecimal) params.get(EParamType.eAmount);
    Account account = accountService.getAccount(accountNumber);
    Optional.ofNullable(account).orElseThrow(()
        -> new NotExistAccountException(Message.NotExistAccount, accountNumber));
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(Message.DeactivatedAccount, accountNumber);
    }
    if (amount.compareTo(BigDecimal.ZERO) < 0){
      return new Response(ErrorMessage.NegativeNumber);
    }
    accountService.deposit(account, amount);
    return new Response(Message.Complete);
  }
}