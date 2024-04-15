package account;

import common.EParamType;
import java.util.HashMap;
import view.InputView;
import view.OutputView;

public interface AccountMaker {
  HashMap<EParamType, Object> makeAccount(InputView inputView, OutputView outputView);
}
