import controller.BankController;
import member.MemberAccountMake;
import view.InputView;
import view.OutputView;

public class BankingApplication {

	public static void main(String[] args)  {
		BankController bankController = new BankController(new InputView(),new OutputView(), new MemberAccountMake());
		bankController.run();

	}
}