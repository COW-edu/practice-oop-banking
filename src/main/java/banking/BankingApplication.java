package banking;

import banking.controller.BankController;

public class BankingApplication {

  public static void main(String[] args) {

    AppConfig appConfig = new AppConfig();
    BankController bankController = appConfig.bankController();
    bankController.startMenu();
  }
}