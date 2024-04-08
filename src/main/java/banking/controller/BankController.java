package banking.controller;


import static banking.constant.ErrorMessage.INCORRECT_INPUT;

import banking.constant.MenuNumber;
import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import banking.handler.MenuActionHandler;
import banking.service.BankService;
import banking.view.BankView;

public class BankController {

  private final BankService bankService;
  private final BankView bankView;
  private final MenuActionHandler menuActionHandler;

  public BankController(BankService bankService, BankView bankView,
      MenuActionHandler menuActionHandler) {
    this.bankService = bankService;
    this.bankView = bankView;
    this.menuActionHandler = menuActionHandler;
    menuActionHandler.initialize(this);
  }


  public void startMenu() {
    boolean isRunning = true;

    do {
      String menuNumberStr = bankView.appStart();
      MenuNumber menuNumber = MenuNumber.findByValue(menuNumberStr);

      if (menuNumber == MenuNumber.EXIT) {
        isRunning = false;
      }

      boolean executed = menuActionHandler.executeAction(menuNumber);
      if (!executed) {
        throw new RuntimeException(INCORRECT_INPUT.getErrorMessage());
      }

    } while (isRunning);
  }


  public void createAccount() {
    AccountDTO accountDTO = bankView.createAccount();
    bankService.createAccount(accountDTO);
  }


  public void depositAmountToAccount() {
    DepositDTO depositDTO = bankView.depositAmountToAccount();
    bankService.depositAmountToAccount(depositDTO);
  }


  public void withdrawAmountToAccount() {
    WithdrawDTO withdrawDTO = bankView.withdrawAmountToAccount();
    bankService.withdrawAmountToAccount(withdrawDTO);
  }


  public void transferAmountToAccount() {
    TransferDTO transferDTO = bankView.transferAmountToAccount();
    bankService.transferAmountToAccount(transferDTO);
  }


  public void findAccountByAccountNumber() {
    BasicAccount findAccount = bankService.retrieveAndComputeInterest(bankView.findAccountInput());
    bankView.findAccountByAccountNumber(findAccount);
  }


  public void exitProgram() {
    bankView.exitProgram();
  }
}
