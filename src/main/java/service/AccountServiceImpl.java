package service;

import account.Account;
import common.ErrorMessage;
import exception.MaxAccountCountException;
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
  public boolean addAccount(Account account) throws MaxAccountCountException {
    if(accountRepository.getAccountListCount() == AccountRepository.MAX_ACCOUNT_COUNT){
      throw new MaxAccountCountException(ErrorMessage.MaxAccountCount);
    }
    if(accountRepository.getAccount(account.getAccountNumber()) == null) {
      accountRepository.addAccount(account);
      return true;
    } else {
      return false;
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
  public int getAccountListCount() {
    return accountRepository.getAccountListCount();
  }

  @Override
  public void deposit(Account account, BigDecimal depositAmount) {
    accountRepository.deposit(account, depositAmount);
  }

  @Override
  public void withdrawal(Account account, BigDecimal withdrawalAmount) {
    accountRepository.withDrawal(account, withdrawalAmount);
  }

  @Override
  public void deactivate(Account account) {
    accountRepository.deactivate(account);
  }

  @Override
  public void activate(Account account) {
    accountRepository.activate(account);
  }
}
