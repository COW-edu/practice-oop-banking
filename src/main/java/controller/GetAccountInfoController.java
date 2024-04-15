package controller;

import account.Account;
import common.EParamType;
import common.Message;
import common.Request;
import common.Response;
import exception.NotExistAccountException;
import java.util.Optional;
import service.AccountService;
import service.AccountServiceImpl;

public class GetAccountInfoController implements BankingController {
  AccountService accountService = AccountServiceImpl.getInstance();

  @Override
  public Response process(Request request) throws NotExistAccountException {
    return getAccountInfo(request);
  }

  public Response getAccountInfo(Request request) throws NotExistAccountException {
    String accountNumber = (String) request.getParam(EParamType.eAccountNumber);
    Account account = accountService.getAccount(accountNumber);
    return new Response(
        Optional.ofNullable(account).orElseThrow(()
            -> new NotExistAccountException(Message.NotExistAccount, accountNumber)));
  }
}
