package controller;

import account.Account;
import common.EParamType;
import common.Message;
import common.Request;
import common.Response;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import java.util.Optional;
import service.AccountService;
import service.AccountServiceImpl;

public class DeactivateAccountController implements BankingController {
  AccountService accountService = AccountServiceImpl.getInstance();

  @Override
  public Response process(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    return deactivate(request);
  }

  private Response deactivate(Request request)
      throws NotExistAccountException, DeactivatedAccountException{
    String accountNumber = (String) request.getParam(EParamType.eAccountNumber);
    Account account = accountService.getAccount(accountNumber);
    Optional.ofNullable(account)
        .orElseThrow(
            () -> new NotExistAccountException(Message.NotExistAccount, accountNumber));
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(Message.DeactivatedAccount, accountNumber);
    }
    accountService.deactivate(account);
    return new Response(Message.Complete);
  }
}
