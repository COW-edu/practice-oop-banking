package view;

import account.Account;
import account.AccountType;
import application.BankingManager;
import common.EParamType;
import common.ErrorMessage;
import common.Message;
import common.RequireMessage;
import common.Response;
import exception.DeactivatedAccountException;
import exception.IndexOutOfRangeException;
import exception.NotExistAccountException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import util.AccountUtil;
import util.MenuUtil;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class BankingView {
  private final BankingManager bankingManager;
  private final InputView inputView;
  private final OutputView outputView;
  public boolean run(){
    EMenu eMenu = selectMenu();
    if(eMenu == null){
      return true;
    }
    return switch(eMenu) {
      case eMakeAccount -> makeAccount();
      case eWithdrawal -> withdrawal();
      case eDeposit -> deposit();
      case eRemittance -> remittance();
      case eAccountInfo -> getAccountInfo();
      case eInterest -> getInterest();
      case eDeactivateAccount -> deactivateAccount();
      case eActivateAccount -> activateAccount();
      case eDeleteAccount -> deleteAccount();
      case eQuit -> {
        outputView.print(Message.Exit);
        yield false;
      }
    };
  }

  private EMenu selectMenu(){
    outputView.print(Message.SELECT_MENU);
    try {
      return MenuUtil.intToMenu(inputView.getInt());
    } catch (NumberFormatException | IndexOutOfRangeException exception) {
      outputView.printError(exception.getMessage());
    }
    return null;
  }

  private boolean makeAccount() {
    try {
      outputView.print(RequireMessage.RequireAccountType);
      AccountType accountType =
          AccountUtil.intToAccountType(inputView.getInt());
      HashMap<EParamType, Object> params =
          accountType.getAccountMaker().makeAccount(inputView, outputView);
      Response response = bankingManager.makeAccount(params);
      Account account = (Account) response.getMessage();
      if(account.isEmpty()){
        outputView.print(Message.AccountCreationFailed);
      } else {
        outputView.print(account.getAccountInfo());
      }
    } catch (NumberFormatException | IndexOutOfRangeException e) {
      outputView.printError(e.getMessage());
    } catch (NotExistAccountException e) {
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean deleteAccount() {
    try{
      outputView.print(Message.Delete.getPrintMessage() + " " +
          RequireMessage.RequireAccountNumber.getPrintMessage());
      Response response = bankingManager.deleteAccount(inputView.getString());
      Message result = (Message) response.getMessage();
      outputView.print(result.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean activateAccount() {
    try{
      outputView.print(Message.Activate.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      Response response = bankingManager.activateAccount(inputView.getString());
      Message result = (Message) response.getMessage();
      outputView.print(result.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean deactivateAccount() {
    try{
      outputView.print(Message.Deactivate.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      Response response = bankingManager.deactivateAccount(inputView.getString());
      Message result = (Message) response.getMessage();
      outputView.print(result.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean getAccountInfo() {
    try {
      outputView.print(RequireMessage.RequireAccountNumber.getPrintMessage());
      Response response = bankingManager.getAccount(inputView.getString());
      Account result = (Account) response.getMessage();
      outputView.print(result.getAccountInfo());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean getInterest() {
    try {
      outputView.print(Message.Interest.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      Response response = bankingManager.getInterest(inputView.getString());
      BigDecimal interest = (BigDecimal) response.getMessage();
      outputView.print(Message.Interest.getPrintMessage() + " ￦"
          + new DecimalFormat("###,###").format(interest));
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean remittance() {
    try {
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String withDrawalAccountNumber = inputView.getString();
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String depositAccountNumber = inputView.getString();
      outputView.print(Message.Remittance.getPrintMessage() + " "
          + RequireMessage.RequireAmount.getPrintMessage());
      BigDecimal amount = inputView.getBigDecimal();
      Response response =
          bankingManager.remittance(withDrawalAccountNumber, depositAccountNumber, amount);
      Message result = (Message) response.getMessage();
      outputView.print(result.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean deposit() {
    try {
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String accountNumber = inputView.getString();
      outputView.print(Message.Deposit.getPrintMessage() + " "
          + RequireMessage.RequireAmount.getPrintMessage());
      BigDecimal depositAmount = inputView.getBigDecimal();
      Response response = bankingManager.deposit(accountNumber, depositAmount);
      Message message = (Message) response.getMessage();
      outputView.print(message.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }

  private boolean withdrawal() {
    try {
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + RequireMessage.RequireAccountNumber.getPrintMessage());
      String accountNumber = inputView.getString();
      outputView.print(Message.Withdrawal.getPrintMessage() + " "
          + RequireMessage.RequireAmount.getPrintMessage());
      BigDecimal withdrawalAmount = inputView.getBigDecimal();
      Response response = bankingManager.withdrawal(accountNumber, withdrawalAmount);
      Message result = (Message) response.getMessage();
      outputView.print(result.getPrintMessage());
    } catch (NotExistAccountException exception){
      outputView.printError(ErrorMessage.NotExistAccount);
    } catch (DeactivatedAccountException e) {
      outputView.printError(ErrorMessage.DeactivatedAccount);
    }
    return true;
  }
}