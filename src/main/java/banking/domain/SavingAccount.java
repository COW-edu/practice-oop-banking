package banking.domain;

import banking.constant.AccountType;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SavingAccount extends BasicAccount {

  private BigDecimal targetAmount;

  @Builder(builderMethodName = "savingAccountBuilder")
  public SavingAccount(AccountType accountType, String accountNumber, String owner,
      BigDecimal balance, boolean isActivated, BigDecimal targetAmount) {
    super(accountType, accountNumber, owner, balance, isActivated);
    this.targetAmount = targetAmount;
  }


  public String getAccountInfo() {
    return "Account = [" +
        "계좌타입=" + super.getAccountType() +
        ", 계좌번호='" + super.getAccountNumber() + '\'' +
        ", 소유주='" + super.getOwner() + '\'' +
        ", 잔액=" + super.getBalance() +
        ", 활성화 여부=" + super.isActivated() +
        ", 목표 금액=" + this.targetAmount +
        " ]" + " \n";
  }
}
