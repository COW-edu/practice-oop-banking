package banking.controller;


import banking.app.BankApp;
import banking.constant.MenuNumber;
import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import banking.hadler.MenuActionHandler;
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

  public void deposit() {
    DepositDTO depositDTO = bankApp.deposit();
    bankService.deposit(depositDTO);
  }

  public void withdraw() {
    WithdrawDTO withdrawDTO = bankApp.withdraw();
    bankService.withdraw(withdrawDTO);
  }

  public void transfer() {
    TransferDTO transferDTO = bankApp.transfer();
    bankService.transfer(transferDTO);
  }

  public void findAccount() {
    BasicAccount findAccount = bankService.retrieveAndComputeInterest(bankApp.findAccountInput());
    bankApp.findAccount(findAccount);
  }

  public void exitProgram() {
    bankApp.exitProgram();
  }
}
