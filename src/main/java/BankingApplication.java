import controller.BankController;
import util.Appconfig;
import view.InputView;
import view.OutputView;

public class BankingApplication {

	public static void main(String[] args)  {
		Appconfig appConfig = new Appconfig();
		BankController bankController = appConfig.bankController();
		bankController.run();
	}
}