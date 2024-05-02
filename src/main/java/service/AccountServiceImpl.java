package service;

import account.Account;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.AccountRepository;
import model.AccountRepositoryImpl;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {
  private final AccountRepository accountRepository = AccountRepositoryImpl.getInstance();

  @Getter
  private static final AccountService instance = new AccountServiceImpl();

  @Override
  public void addAccount(Account account) {
    if(accountRepository.getAccount(account.getAccountNumber()) == null) {
      accountRepository.addAccount(account);
    }
  }

  @Override
  public void deleteAccount(Account account) {
    accountRepository.deleteAccount(account);
  }

  @Override
  public Account getAccount(String accountNumber) {
    return accountRepository.getAccount(accountNumber);
  }

  @Override
  public boolean checkNumber(String accountNumber) {
    Account account = accountRepository.getAccount(accountNumber);
    return account != null;
  }

  @Override
  public void deposit(Account account, BigDecimal depositAmount) {
    account.deposit(depositAmount);
  }

  @Override
  public void withdrawal(Account account, BigDecimal withdrawalAmount) {
    account.withdrawal(withdrawalAmount);
  }

  @Override
  public void deactivate(Account account) {
    account.deactivate();
  }

  @Override
  public void activate(Account account) {
    account.activate();
  }
}
