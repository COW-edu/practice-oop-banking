package service;

import account.Account;
import java.math.BigDecimal;

public interface AccountService {
  void addAccount(Account account);

  void deleteAccount(Account account);

  void activate(Account account);

  void deactivate(Account account);

  void deposit(Account account, BigDecimal depositAmount);

  void withdrawal(Account account, BigDecimal withdrawalAmount);

  Account getAccount(String accountNumber);

  boolean checkNumber(String accountNumber);
}