package account;

import common.EParamType;
import common.RequireMessage;
import java.util.HashMap;
import view.InputView;
import view.OutputView;

public class BasicAccountMaker implements AccountMaker {

  @Override
  public HashMap<EParamType, Object> makeAccount(InputView inputView, OutputView outputView) throws NumberFormatException{
    HashMap<EParamType, Object> accountInfo = new HashMap<>();
    AccountType accountType = AccountType.BASIC_ACCOUNT;
    outputView.print(RequireMessage.RequireOwner);
    String owner = inputView.getString();
    outputView.print(RequireMessage.RequireActivation);
    boolean activation = inputView.getBoolean();
    accountInfo.put(EParamType.eAccountType, accountType);
    accountInfo.put(EParamType.eOwner, owner);
    accountInfo.put(EParamType.eActivation, activation);
    return accountInfo;
  }
}
