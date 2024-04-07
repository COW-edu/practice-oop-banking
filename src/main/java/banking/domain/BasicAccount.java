package banking.domain;

import banking.constant.AccountType;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasicAccount {

  private AccountType accountType;
  private String accountNumber;
  private String owner;
  private BigDecimal balance;
  private boolean isActivated;

  @Builder(builderMethodName = "basicAccountBuilder")
  public BasicAccount(AccountType accountType, String accountNumber, String owner,
      BigDecimal balance, boolean isActivated) {
    this.accountType = accountType;
    this.accountNumber = accountNumber;
    this.owner = owner;
    this.balance = balance;
    this.isActivated = isActivated;
  }


  public String getAccountInfo() {
    return "계좌정보 = [" +
        " 계좌타입=" + accountType +
        ", 계좌번호='" + accountNumber + '\'' +
        ", 소유주='" + owner + '\'' +
        ", 잔액=" + balance +
        ", 활성화 여부=" + isActivated +
        " ]" + " \n";
  }


}
