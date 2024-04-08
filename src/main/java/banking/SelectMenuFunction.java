package banking;

import common.Message;
import controller.BankingController;
import exception.IndexOutOfRangeException;
import java.util.HashMap;
import util.MenuUtil;
import view.EMenu;
import view.InputView;
import view.OutputView;

public class SelectMenuFunction extends BankingFunction {

  private final HashMap<EMenu, BankingFunction> functions;
  public SelectMenuFunction(
      HashMap<EMenu, BankingFunction> functions,
      BankingController bankingController,
      InputView inputView,
      OutputView outputView) {
    super(bankingController, inputView, outputView);
    this.functions = functions;
  }

  @Override
  public boolean execute() {
    return getMenu();
  }

  public boolean getMenu() {
    outputView.print(Message.SELECT_MENU);
    boolean result = true;
    try {
      EMenu eMenu = MenuUtil.intToMenu(inputView.getInt());
      result = functions.get(eMenu).execute();
    } catch (NumberFormatException | IndexOutOfRangeException exception) {
      outputView.printError(exception.getMessage());
    }
    return result;
  }
}
