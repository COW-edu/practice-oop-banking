package service;

import account.Account;
import exception.MaxAccountCountException;
import java.math.BigDecimal;

public interface AccountService {
  boolean addAccount(Account account) throws MaxAccountCountException;

  void deleteAccount(Account account);

  void activate(Account account);

  void deactivate(Account account);

  void deposit(Account account, BigDecimal depositAmount);

  void withdrawal(Account account, BigDecimal withdrawalAmount);

  Account getAccount(String accountNumber);

  boolean checkNumber(String accountNumber);

  int getAccountListCount();
}