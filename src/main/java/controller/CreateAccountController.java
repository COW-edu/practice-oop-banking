package controller;

import account.Account;
import account.AccountType;
import account.BasicAccount;
import account.SavingAccount;
import common.EParamType;
import common.Request;
import common.Response;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import service.AccountService;
import service.AccountServiceImpl;

public class CreateAccountController implements BankingController {
  private static final int TRY_CREATE_MAX_COUNT = 10;
  private static final int MIN_ACCOUNT_NUMBER = 100000000;
  private static final int MAX_ACCOUNT_NUMBER = 999999999;
  AccountService accountService = AccountServiceImpl.getInstance();

  @Override
  public Response process(Request request) {
    HashMap<EParamType, Object> params = request.getParams();
    AccountType accountType = (AccountType) params.get(EParamType.eAccountType);
    return switch(accountType){
      case SAVING_ACCOUNT -> makeSavingAccount(params);
      case BASIC_ACCOUNT -> makeBasicAccount(params);
    };
  }

  private String makeAccountNumber() {
    int tryCount = 0;
    String accountNumber;
    while (tryCount < TRY_CREATE_MAX_COUNT) {
      accountNumber
          = ThreadLocalRandom.current().nextInt(MIN_ACCOUNT_NUMBER, MAX_ACCOUNT_NUMBER) + "";
      if (!accountService.checkNumber(accountNumber)) {
        return accountNumber;
      }
      tryCount++;
    }
    return null;
  }

  private Response makeSavingAccount(HashMap<EParamType, Object> params){
    String accountNumber = makeAccountNumber();
    if (accountNumber == null) {
      return new Response(Account.empty());
    }
    String owner = (String) params.get(EParamType.eOwner);
    boolean activation = (boolean) params.get(EParamType.eActivation);
    BigDecimal targetAmount = (BigDecimal) params.get(EParamType.eTargetAmount);
    BigDecimal balance = new BigDecimal(0);
    Account account = SavingAccount.builder()
        .accountNumber(accountNumber)
        .owner(owner)
        .balance(balance)
        .targetAmount(targetAmount)
        .activation(activation)
        .build();
    accountService.addAccount(account);
    return new Response(account);
  }

  private Response makeBasicAccount(HashMap<EParamType, Object> params){
    String accountNumber = makeAccountNumber();
    if (accountNumber == null) {
      return new Response(Account.empty());
    }
    String owner = (String) params.get(EParamType.eOwner);
    boolean activation = (boolean) params.get(EParamType.eActivation);
    BigDecimal balance = new BigDecimal(0);
    Account account = BasicAccount.builder()
        .accountNumber(accountNumber)
        .owner(owner)
        .balance(balance)
        .activation(activation)
        .build();
    accountService.addAccount(account);
    return new Response(account);
  }
}