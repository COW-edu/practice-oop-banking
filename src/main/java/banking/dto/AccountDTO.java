package banking.dto;

import banking.constant.AccountType;
import banking.domain.BasicAccount;
import banking.domain.SavingAccount;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountDTO {

  private int typeNum;
  private String accountNumber;
  private String owner;
  private BigDecimal money;
  private boolean isActivated;
  private BigDecimal targetAmount;

  @Builder
  public AccountDTO(int typeNum, String accountNumber, String owner, BigDecimal money,
      boolean isActivated,
      BigDecimal targetAmount) {
    this.typeNum = typeNum;
    this.accountNumber = accountNumber;
    this.owner = owner;
    this.money = money;
    this.isActivated = isActivated;
    this.targetAmount = targetAmount;
  }


  public BasicAccount createBasicAccount() {
    return BasicAccount.basicAccountBuilder()
        .accountType(AccountType.BASIC)
        .accountNumber(accountNumber)
        .owner(owner)
        .balance(money)
        .isActivated(true)
        .build();
  }

  public SavingAccount createSavingAccount() {
    return SavingAccount.savingAccountBuilder()
        .accountType(AccountType.SAVING)
        .accountNumber(accountNumber)
        .owner(owner)
        .balance(money)
        .isActivated(true)
        .targetAmount(targetAmount)
        .build();
  }
}