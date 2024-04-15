package model;

import account.Account;

public interface AccountRepository {

  void addAccount(Account account);

  void deleteAccount(Account account);

  Account getAccount(String accountNumber);

  int getAccountListCount();
}
