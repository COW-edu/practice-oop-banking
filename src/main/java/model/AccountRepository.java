package model;

import account.Account;

public interface AccountRepository {

  int MAX_ACCOUNT_COUNT = 50;

  void addAccount(Account account);

  void deleteAccount(Account account);

  Account getAccount(String accountNumber);

  int getAccountListCount();
}
