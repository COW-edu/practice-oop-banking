package service;

import account.Account;
import exception.MaxAccountCountException;
import java.math.BigDecimal;

public interface AccountService {
  public boolean addAccount(Account account) throws MaxAccountCountException;

  public void deleteAccount(Account account);

  public void activate(Account account);

  public void deactivate(Account account);

  public void deposit(Account account, BigDecimal depositAmount);

  public void withdrawal(Account account, BigDecimal withdrawalAmount);

  public Account getAccount(String accountNumber);

  public boolean checkNumber(String accountNumber);

  public int getAccountListCount();
}