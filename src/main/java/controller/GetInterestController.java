package controller;

import account.Account;
import common.EParamType;
import common.Message;
import common.Request;
import common.Response;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import service.AccountService;
import service.AccountServiceImpl;
import service.InterestService;
import service.InterestServiceImpl;

public class GetInterestController implements BankingController {
  AccountService accountService = AccountServiceImpl.getInstance();
  InterestService interestService = InterestServiceImpl.getInstance();

  @Override
  public Response process(Request request)
      throws NotExistAccountException, DeactivatedAccountException {
    return getInterest(request);
  }

  private Response getInterest(Request request) throws DeactivatedAccountException{
    String accountNumber = (String) request.getParam(EParamType.eAccountNumber);
    Account account = accountService.getAccount(accountNumber);
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(Message.DeactivatedAccount, accountNumber);
    }
    BigDecimal interest = interestService.getInterest(account.getAccountType(), account.getBalance());
    return new Response(interest);
  }
}
