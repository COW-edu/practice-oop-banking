package application;

import view.BankingView;

public class Application {
	public static void main(String[] args) {
		AppConfig config = new AppConfig();
		BankingView banking = config.banking();
		boolean isRunning;
		do {
			isRunning = banking.run();
		} while (isRunning);
	}
}