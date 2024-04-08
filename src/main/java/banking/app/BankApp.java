package banking.app;


import static banking.constant.ErrorMessage.TYPE_FOR_ACCOUNT;
import static banking.constant.ErrorMessage.TYPE_FOR_DECIMAL;
import static banking.constant.InformationMessage.ACCOUNT_INFO;
import static banking.constant.InformationMessage.ACCOUNT_NUMBER;
import static banking.constant.InformationMessage.ACCOUNT_OWNER;
import static banking.constant.InformationMessage.ACCOUNT_TYPE;
import static banking.constant.InformationMessage.DEPOSIT_ACCOUNT_NUMBER;
import static banking.constant.InformationMessage.DEPOSIT_AMOUNT;
import static banking.constant.InformationMessage.EXIT;
import static banking.constant.InformationMessage.MENU;
import static banking.constant.InformationMessage.TARGET_AMOUNT;
import static banking.constant.InformationMessage.TRANSFER_AMOUNT;
import static banking.constant.InformationMessage.WITHDRAW_ACCOUNT_NUMBER;
import static banking.constant.InformationMessage.WITHDRAW_AMOUNT;

import banking.constant.InformationMessage;
import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import banking.exception.FormatException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BankApp {

  private static final Scanner sc = new Scanner(System.in);
  
  public String appStart() {
    System.out.println(informationMessage(MENU));
    return BankApp.input();
  }


  public AccountDTO createAccount() {
    System.out.println(informationMessage(ACCOUNT_TYPE));
    int typeNumber = Integer.parseInt(input());

    System.out.println(informationMessage(ACCOUNT_NUMBER));
    String accountNumber = formatAccountNumber();

    System.out.println(informationMessage(ACCOUNT_OWNER));
    String owner = input();

    System.out.println(informationMessage(DEPOSIT_AMOUNT));
    BigDecimal amount = inputDecimal(TYPE_FOR_DECIMAL.getErrorMessage());

    BigDecimal targetAmount = (typeNumber == 2) ? inputTargetAmount() : null;

    return AccountDTO.builder().typeNum(typeNumber).accountNumber(accountNumber).owner(owner)
        .money(amount).isActivated(true).targetAmount(targetAmount).build();
  }


  public DepositDTO depositAmountToAccount() {
    System.out.println(informationMessage(DEPOSIT_ACCOUNT_NUMBER));
    String accountNumber = formatAccountNumber();

    System.out.println(informationMessage(DEPOSIT_AMOUNT));
    BigDecimal depositAmount = inputDecimal(TYPE_FOR_DECIMAL.getErrorMessage());

    return DepositDTO.builder().accountNumber(accountNumber).depositAmount(depositAmount).build();
  }


  public WithdrawDTO withdrawAmountToAccount() {
    System.out.println(informationMessage(WITHDRAW_ACCOUNT_NUMBER));
    String accountNumber = formatAccountNumber();

    System.out.println(informationMessage(WITHDRAW_AMOUNT));
    BigDecimal withdrawAmount = inputDecimal(TYPE_FOR_DECIMAL.getErrorMessage());

    return WithdrawDTO.builder().accountNumber(accountNumber).withdrawAmount(withdrawAmount)
        .build();
  }


  public TransferDTO transferAmountToAccount() {
    System.out.println(informationMessage(DEPOSIT_ACCOUNT_NUMBER));
    String depositAccountNumber = formatAccountNumber();

    System.out.println(informationMessage(WITHDRAW_ACCOUNT_NUMBER));
    String withdrawAccountNumber = formatAccountNumber();

    System.out.println(informationMessage(TRANSFER_AMOUNT));
    BigDecimal transferAmount = inputDecimal(TYPE_FOR_DECIMAL.getErrorMessage());

    return TransferDTO.builder().depositAccountNumber(depositAccountNumber)
        .withdrawAccountNumber(withdrawAccountNumber).transferAmount(transferAmount).build();
  }


  public void findAccountByAccountNumber(BasicAccount findAccount) {
    System.out.println(informationMessage(ACCOUNT_INFO));
    System.out.println(findAccount.getAccountInfo());
  }


  public String findAccountInput() {
    System.out.println(informationMessage(ACCOUNT_NUMBER));
    String accountNumber = formatAccountNumber();
    System.out.println(accountNumber);
    return accountNumber;
  }


  public static String input() {
    return sc.nextLine();
  }


  private String formatAccountNumber() {

    String inputString = input();

    if (inputString.length() != 8) {
      throw new FormatException(TYPE_FOR_ACCOUNT.getErrorMessage());
    }

    DecimalFormat df = new DecimalFormat("00000000");

    try {
      long number = Long.parseLong(inputString);
      return df.format(number);
    } catch (NumberFormatException e) {
      throw new FormatException(TYPE_FOR_ACCOUNT.getErrorMessage());
    }
  }


  public void exitProgram() {
    System.out.println(informationMessage(EXIT));
  }


  private BigDecimal inputTargetAmount() {
    System.out.println(informationMessage(TARGET_AMOUNT));
    return new BigDecimal(input());
  }


  private String informationMessage(InformationMessage message) {
    return message.getMessage();
  }


  private BigDecimal inputDecimal(String msg) {
    BigDecimal amount;
    try {
      amount = new BigDecimal(input());
    } catch (NumberFormatException e) {
      throw new RuntimeException(msg);
    }
    return amount;
  }
}
