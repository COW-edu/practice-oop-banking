import controller.BankController;
import util.AppConfig;

public class BankingApplication {

	public static void main(String[] args)  {
		AppConfig appConfig = new AppConfig();
		BankController bankController = appConfig.bankController();
		bankController.run();
	}
}