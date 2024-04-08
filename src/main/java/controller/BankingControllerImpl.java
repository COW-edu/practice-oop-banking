package controller;

import account.Account;
import account.AccountType;
import account.BasicAccount;
import account.SavingAccount;
import common.ErrorMessage;
import exception.DeactivatedAccountException;
import exception.MaxAccountCountException;
import exception.NegativeNumberException;
import exception.NotEnoughBalanceException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.AccountRepository;
import service.AccountService;
import service.AccountServiceImpl;
import service.InterestService;
import service.InterestServiceImpl;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BankingControllerImpl implements BankingController {

  private final InterestService interestService = InterestServiceImpl.getInstance();
  private final AccountService accountInformationService = AccountServiceImpl.getInstance();

  private String makeAccountNumber() throws MaxAccountCountException {
    int size = accountInformationService.getAccountListCount();
    String accountNumber;
    while (size < AccountRepository.MAX_ACCOUNT_COUNT) {
      accountNumber =
          ((Math.random() * 899999999) + 100000000) + ""; // 100000000~999999999 사이의 랜덤 숫자
      if (!accountInformationService.checkNumber(accountNumber)) {
        return accountNumber;
      }
      size = accountInformationService.getAccountListCount();
    }
    throw new MaxAccountCountException(ErrorMessage.MaxAccountCount);
  }

  public void deleteAccount(String accountNumber) throws NotExistAccountException {
    Account account = accountInformationService.getAccount(accountNumber);
    Optional.ofNullable(account)
        .orElseThrow(
            () -> new NotExistAccountException(ErrorMessage.NotExistAccount, accountNumber));
    accountInformationService.deleteAccount(account);
  }

  @Override
  public void activateAccount(String accountNumber) throws NotExistAccountException {
    Account account = accountInformationService.getAccount(accountNumber);
    Optional.ofNullable(account)
        .orElseThrow(
            () -> new NotExistAccountException(ErrorMessage.NotExistAccount, accountNumber));
    accountInformationService.activate(account);
  }

  @Override
  public void deactivateAccount(String accountNumber)
      throws DeactivatedAccountException, NotExistAccountException {
    Account account = accountInformationService.getAccount(accountNumber);
    Optional.ofNullable(account)
        .orElseThrow(
            () -> new NotExistAccountException(ErrorMessage.NotExistAccount, accountNumber));
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(ErrorMessage.DeactivatedAccount, accountNumber);
    }
    accountInformationService.deactivate(account);
  }

  @Override
  public String createAccount(
      AccountType accountType,
      String owner,
      boolean activation) throws MaxAccountCountException {
    Account account;
    boolean addResult;
    do {
      account = BasicAccount
          .builder()
          .accountNumber(makeAccountNumber())
          .owner(owner)
          .balance(new BigDecimal(0))
          .activation(activation)
          .build();
      addResult = accountInformationService.addAccount(account);
    } while (!addResult);
    return account.getAccountInfo();
  }

  @Override
  public String createAccount(
      AccountType accountType,
      String owner,
      BigDecimal targetAmount,
      boolean activation) throws MaxAccountCountException, NegativeNumberException {
    if (targetAmount.compareTo(BigDecimal.ZERO) < 0) {
      throw new NegativeNumberException(ErrorMessage.NegativeNumber);
    }
    Account account;
    boolean addResult;
    do {
      account = SavingAccount.builder()
          .accountNumber(makeAccountNumber())
          .owner(owner)
          .balance(new BigDecimal(0))
          .targetAmount(targetAmount)
          .activation(activation)
          .build();
      addResult = accountInformationService.addAccount(account);
    } while (!addResult);
    return account.getAccountInfo();
  }

  @Override
  public Account getAccount(String accountNumber) throws NotExistAccountException {
    Account account = accountInformationService.getAccount(accountNumber);
    return Optional.ofNullable(account)
        .orElseThrow(
            () -> new NotExistAccountException(ErrorMessage.NotExistAccount, accountNumber));
  }

  @Override
  public void deposit(String accountNumber, BigDecimal depositAmount)
      throws NotExistAccountException, DeactivatedAccountException, NegativeNumberException {
    Account account = getAccount(accountNumber);
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(ErrorMessage.DeactivatedAccount, accountNumber);
    }
    if (depositAmount.compareTo(BigDecimal.ZERO) < 0){
      throw new NegativeNumberException(ErrorMessage.NegativeNumber);
    }
    accountInformationService.deposit(account, depositAmount);
  }

  @Override
  public void withdrawal(String accountNumber, BigDecimal withdrawalAmount)
      throws NotExistAccountException, NotEnoughBalanceException, DeactivatedAccountException, NegativeNumberException {
    Account account = getAccount(accountNumber);
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(ErrorMessage.DeactivatedAccount, accountNumber);
    }
    if (withdrawalAmount.compareTo(BigDecimal.ZERO) < 0){
      throw new NegativeNumberException(ErrorMessage.NegativeNumber);
    }
    if (!account.canWithdrawal(withdrawalAmount)){
      throw new NotEnoughBalanceException(ErrorMessage.NotEnoughBalanceException, account.getBalance());
    }
    accountInformationService.withdrawal(account, withdrawalAmount);
  }

  @Override
  public void remittance(
      String withdrawalAccountNumber,
      String depositAccountNumber,
      BigDecimal remittanceAmount)
      throws NotExistAccountException, NotEnoughBalanceException, DeactivatedAccountException, NegativeNumberException {
    Account depositAccount = getAccount(depositAccountNumber);
    Account withdrawalAccount = getAccount(withdrawalAccountNumber);
    if (withdrawalAccount.isDeactivate()){
      throw new DeactivatedAccountException(ErrorMessage.DeactivatedAccount, withdrawalAccountNumber);
    }
    if (depositAccount.isDeactivate()){
      throw new DeactivatedAccountException(ErrorMessage.DeactivatedAccount, depositAccountNumber);
    }
    if (remittanceAmount.compareTo(BigDecimal.ZERO) < 0){
      throw new NegativeNumberException(ErrorMessage.NegativeNumber);
    }
    if (!withdrawalAccount.canWithdrawal(remittanceAmount)){
      throw new NotEnoughBalanceException(ErrorMessage.NotEnoughBalanceException, withdrawalAccount.getBalance());
    }
    accountInformationService.withdrawal(withdrawalAccount, remittanceAmount);
    accountInformationService.deposit(depositAccount, remittanceAmount);
  }

  @Override
  public String getAccountInfo(String accountNumber) throws NotExistAccountException {
    return getAccount(accountNumber).getAccountInfo();
  }

  @Override
  public BigDecimal getInterest(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException {
    Account account = getAccount(accountNumber);
    if (account.isDeactivate()){
      throw new DeactivatedAccountException(ErrorMessage.DeactivatedAccount, accountNumber);
    }
    return interestService.getInterest(account.getAccountType(), account.getBalance());
  }
}
