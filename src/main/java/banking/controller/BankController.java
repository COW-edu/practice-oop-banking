package banking.controller;


import banking.app.BankApp;
import banking.constant.MenuNumber;
import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import banking.handler.MenuActionHandler;
import banking.service.BankService;

public class BankController {

  private final BankService bankService;
  private final BankApp bankApp;
  private final MenuActionHandler menuActionHandler;

  public BankController(BankService bankService, BankApp bankApp,
      MenuActionHandler menuActionHandler) {
    this.bankService = bankService;
    this.bankApp = bankApp;
    this.menuActionHandler = menuActionHandler;
    menuActionHandler.initialize(this);
  }


  public void startMenu() {
    boolean isRunning = true;

    do {
      String menuNumberStr = bankApp.appStart();
      MenuNumber menuNumber = MenuNumber.findByValue(menuNumberStr);

      if (menuNumber == MenuNumber.EXIT) {
        isRunning = false;
      }

      boolean executed = menuActionHandler.executeAction(menuNumber);
      if (!executed) {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        return;
      }

    } while (isRunning);
  }

  public void createAccount() {
    AccountDTO accountDTO = bankApp.createAccount();
    bankService.createAccount(accountDTO);
  }

  public void depositAmountToAccount() {
    DepositDTO depositDTO = bankApp.depositAmountToAccount();
    bankService.depositAmountToAccount(depositDTO);
  }

  public void withdrawAmountToAccount() {
    WithdrawDTO withdrawDTO = bankApp.withdrawAmountToAccount();
    bankService.withdrawAmountToAccount(withdrawDTO);
  }

  public void transferAmountToAccount() {
    TransferDTO transferDTO = bankApp.transferAmountToAccount();
    bankService.transferAmountToAccount(transferDTO);
  }

  public void findAccountByAccountNumber() {
    BasicAccount findAccount = bankService.retrieveAndComputeInterest(bankApp.findAccountInput());
    bankApp.findAccountByAccountNumber(findAccount);
  }

  public void exitProgram() {
    bankApp.exitProgram();
  }
}
