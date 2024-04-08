package banking;

import controller.BankingController;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import view.InputView;
import view.OutputView;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class BankingFunction {
  protected final BankingController bankingController;
  protected final InputView inputView;
  protected final OutputView outputView;
  public abstract boolean execute();
}
