package controller;

import account.Account;
import account.AccountType;
import exception.DeactivatedAccountException;
import exception.MaxAccountCountException;
import exception.NegativeNumberException;
import exception.NotEnoughBalanceException;
import exception.NotExistAccountException;
import java.math.BigDecimal;

public interface BankingController {
  String createAccount(
      AccountType accountType, String owner, boolean activation)
      throws MaxAccountCountException;

  String createAccount(
      AccountType accountType, String owner, BigDecimal targetAmount, boolean activation)
      throws MaxAccountCountException, NegativeNumberException;

  void deleteAccount(String accountNumber) throws NotExistAccountException;

  void activateAccount(String accountNumber) throws NotExistAccountException;

  void deactivateAccount(String accountNumber)
      throws DeactivatedAccountException, NotExistAccountException;

  Account getAccount(String accountNumber) throws NotExistAccountException;

  void deposit(String accountNumber, BigDecimal depositAmount)
      throws NotExistAccountException, DeactivatedAccountException, NegativeNumberException;

  void withdrawal(String accountNumber, BigDecimal withdrawalAmount)
      throws NotExistAccountException, NotEnoughBalanceException, DeactivatedAccountException, NegativeNumberException;

  void remittance(
      String withdrawalAccountNumber, String depositAccountNumber, BigDecimal remittanceAmount)
      throws NotExistAccountException, NotEnoughBalanceException, DeactivatedAccountException, NegativeNumberException;

  String getAccountInfo(String accountNumber) throws NotExistAccountException;

  BigDecimal getInterest(String accountNumber)
      throws NotExistAccountException, DeactivatedAccountException;
}
