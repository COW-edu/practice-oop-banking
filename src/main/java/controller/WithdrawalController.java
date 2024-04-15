package controller;

import account.Account;
import common.EParamType;
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

public class WithdrawalController implements BankingController {
  AccountService accountService = AccountServiceImpl.getInstance();

  @Override
  public Response process(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    return withdrawal(request);
  }

  private Response withdrawal(Request request)
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
      return new Response(Message.NegativeNumber);
    }
    if (!account.canWithdrawal(amount)){
      return new Response(Message.NotEnoughBalanceException);
    }
    accountService.withdrawal(account, amount);
    return new Response(Message.Complete);
  }
}
