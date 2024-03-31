package banking;

import banking.account.view.BankView;

import javax.swing.text.View;

public class BankingApplication {

	public static void main(String[] args) {
		BankView bankView = new BankView();
		bankView.startMenu();
	}
}