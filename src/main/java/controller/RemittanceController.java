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

public class RemittanceController implements BankingController {
  AccountService accountService = AccountServiceImpl.getInstance();

  @Override
  public Response process(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    return remittance(request);
  }

  private Account checkAccount(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
    Account account = accountService.getAccount(accountNumber);
    Optional.ofNullable(account).orElseThrow( ()
        -> new NotExistAccountException(Message.NotExistAccount, accountNumber));
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(Message.DeactivatedAccount, accountNumber);
    }
    return account;
  }

  private Response remittance(Request request)
      throws NotExistAccountException, DeactivatedAccountException{
    HashMap<EParamType, Object> params = request.getParams();
    BigDecimal amount = (BigDecimal) params.get(EParamType.eAmount);
    String withdrawalAccountNumber = (String) params.get(EParamType.eWithdrawalAccountNumber);
    String depositAccountNumber = (String) params.get(EParamType.eDepositAccountNumber);
    Account withdrawalAccount = checkAccount(withdrawalAccountNumber);
    Account depositAccount = checkAccount(depositAccountNumber);
    if (amount.compareTo(BigDecimal.ZERO) < 0){
      return new Response(Message.NegativeNumber);
    }
    if (!withdrawalAccount.canWithdrawal(amount)){
      return new Response(Message.NotEnoughBalanceException);
    }
    accountService.withdrawal(withdrawalAccount, amount);
    accountService.deposit(depositAccount, amount);
    return new Response(Message.Complete);
  }
}
