package account;

import common.EParamType;
import common.Message;
import common.RequireMessage;
import java.math.BigDecimal;
import java.util.HashMap;
import view.InputView;
import view.OutputView;

public class SavingAccountMaker implements AccountMaker {

  @Override
  public HashMap<EParamType, Object> makeAccount(InputView inputView, OutputView outputView) throws NumberFormatException{
    HashMap<EParamType, Object> accountInfo = new HashMap<>();
    AccountType accountType = AccountType.SAVING_ACCOUNT;
    outputView.print(RequireMessage.RequireOwner);
    String owner = inputView.getString();
    outputView.print(RequireMessage.RequireActivation);
    boolean activation = inputView.getBoolean();
    outputView.print(Message.Target.getPrintMessage() + " " +
        RequireMessage.RequireAmount.getPrintMessage());
    BigDecimal targetAmount = inputView.getBigDecimal();
    accountInfo.put(EParamType.eAccountType, accountType);
    accountInfo.put(EParamType.eOwner, owner);
    accountInfo.put(EParamType.eActivation, activation);
    accountInfo.put(EParamType.eTargetAmount, targetAmount);
    return accountInfo;
  }
}
