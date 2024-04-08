package banking.service.validation;

import static banking.constant.ErrorMessage.CHECK_GOAL_AMOUNT;

import banking.domain.BasicAccount;
import banking.domain.SavingAccount;
import banking.dto.AccountDTO;
import java.util.Optional;

public class AccountValidationService {

  public boolean isTargetAmountNull(AccountDTO accountDTO) {
    return accountDTO.getTargetAmount() == null;
  }


  public boolean validateAndCheckWithdraw(BasicAccount withdrawSavingAccount) {
    return Optional.ofNullable(withdrawSavingAccount)
        .filter(this::isSavingAccountEnableForWithdraw)
        .map(acc -> true)
        .orElseGet(() -> {
          if (withdrawSavingAccount instanceof SavingAccount) {
            throw new RuntimeException(CHECK_GOAL_AMOUNT.getErrorMessage());
          }
          return false;
        });
  }


  private boolean isSavingAccountEnableForWithdraw(BasicAccount withdrawSavingAccount) {
    return withdrawSavingAccount instanceof SavingAccount savingAccount &&
        savingAccount.getBalance().compareTo(savingAccount.getTargetAmount()) >= 0;
  }
}
