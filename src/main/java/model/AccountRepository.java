package model;

import account.Account;
import java.math.BigDecimal;

public interface AccountRepository {

  int MAX_ACCOUNT_COUNT = 50;

  void addAccount(Account account);

  void deleteAccount(Account account);

  Account getAccount(String accountNumber);

  int getAccountListCount();

  void deposit(Account account, BigDecimal depositAmount);

  void withDrawal(Account account, BigDecimal withdrawalAmount);

  void deactivate(Account account);

  void activate(Account account);
}
