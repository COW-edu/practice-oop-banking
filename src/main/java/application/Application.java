package application;

import view.BankingManager;

public class Application {
	public static void main(String[] args) {
		AppConfig config = new AppConfig();
		BankingManager banking = config.banking();
		banking.run();
	}
}