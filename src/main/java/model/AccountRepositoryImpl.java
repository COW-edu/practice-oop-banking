package model;

import account.Account;
import java.util.HashMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountRepositoryImpl implements AccountRepository {
  private final HashMap<String, Account> accounts = new HashMap<>();

  @Getter
  private static final AccountRepository instance = new AccountRepositoryImpl();

  @Override
  public void addAccount(Account account) {
    accounts.put(account.getAccountNumber(), account);
  }

  @Override
  public void deleteAccount(Account account) {
    accounts.remove(account.getAccountNumber());
  }

  @Override
  public Account getAccount(String accountNumber) {
    return accounts.get(accountNumber);
  }

  @Override
  public int getAccountListCount() {
    return accounts.size();
  }
}
