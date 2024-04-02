package banking;

import banking.account.view.BankView;

import javax.swing.text.View;

public class BankingApplication {

	public static void main(String[] args) {

		AppConfig appConfig = new AppConfig();
		BankView bankView = appConfig.bankView();
		bankView.startMenu();
	}
}