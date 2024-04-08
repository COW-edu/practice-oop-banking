package controller;

import account.Account;
import account.AccountType;
import exception.DeactivatedAccountException;
import exception.IndexOutOfRangeException;
import exception.MaxAccountCountException;
import exception.NegativeNumberException;
import exception.NotEnoughBalanceException;
import exception.NotExistAccountException;
import java.math.BigDecimal;

public interface BankingController {
  public String createAccount(
      AccountType accountType, String owner, boolean activation)
      throws MaxAccountCountException;

  public String createAccount(
      AccountType accountType, String owner, BigDecimal targetAmount, boolean activation)
      throws MaxAccountCountException, NegativeNumberException;

  public void deleteAccount(String accountNumber) throws NotExistAccountException;

  public void activateAccount(String accountNumber) throws NotExistAccountException;

  public void deactivateAccount(String accountNumber)
      throws DeactivatedAccountException, NotExistAccountException;

  public Account getAccount(String accountNumber) throws NotExistAccountException;

  public void deposit(String accountNumber, BigDecimal depositAmount)
      throws NotExistAccountException, DeactivatedAccountException, NegativeNumberException;

  public void withdrawal(String accountNumber, BigDecimal withdrawalAmount)
      throws NotExistAccountException, NotEnoughBalanceException, DeactivatedAccountException, NegativeNumberException;

  public void remittance(
      String withdrawalAccountNumber, String depositAccountNumber, BigDecimal remittanceAmount)
      throws NotExistAccountException, NotEnoughBalanceException, DeactivatedAccountException, NegativeNumberException;

  public String getAccountInfo(String accountNumber) throws NotExistAccountException;

  public BigDecimal getInterest(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException;
}
