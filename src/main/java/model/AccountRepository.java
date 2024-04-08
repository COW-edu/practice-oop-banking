package model;

import account.Account;
import java.math.BigDecimal;

public interface AccountRepository {

  public static final int MAX_ACCOUNT_COUNT = 50;

  public void addAccount(Account account);

  public void deleteAccount(Account account);

  public Account getAccount(String accountNumber);

  public int getAccountListCount();

  public void deposit(Account account, BigDecimal depositAmount);

  public void withDrawal(Account account, BigDecimal withdrawalAmount);

  public void deactivate(Account account);

  public void activate(Account account);
}
