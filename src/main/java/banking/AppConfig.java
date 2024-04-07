package banking;


import static banking.constant.AccountType.BASIC;
import static banking.constant.AccountType.SAVING;

import banking.app.BankApp;
import banking.constant.AccountType;
import banking.controller.BankController;
import banking.handler.MenuActionHandler;
import banking.interestpolicy.InterestCalculator;
import banking.interestpolicy.NormalInterestCalculator;
import banking.interestpolicy.SavingInterestCalculator;
import banking.repository.BankRepository;
import banking.repository.MemoryBankRepository;
import banking.service.BankService;
import banking.service.BankServiceImpl;
import banking.service.validation.AccountValidationService;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {

  
  public BankApp bankApp() {
    return new BankApp();
  }


  public Map<AccountType, InterestCalculator> interestCalculator() {
    Map<AccountType, InterestCalculator> interestPolicy = new HashMap<>();
    interestPolicy.put(BASIC, new NormalInterestCalculator());
    interestPolicy.put(SAVING, new SavingInterestCalculator());
    return interestPolicy;
  }


  public BankController bankController() {
    return new BankController(bankService(), bankApp(), menuActionHandler());
  }


  public BankRepository bankRepository() {
    return new MemoryBankRepository();
  }


  public MenuActionHandler menuActionHandler() {
    return new MenuActionHandler();
  }


  public BankService bankService() {
    return new BankServiceImpl(bankRepository(), interestCalculator(), accountValidationService());
  }


  public AccountValidationService accountValidationService() {
    return new AccountValidationService();
  }


}
