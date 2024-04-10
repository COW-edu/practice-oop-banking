package Week2.Account;

import java.math.BigDecimal;

import Week2.Account.Account;
import Week2.Account.AccountType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
public class BasicAccount implements Account {

    private final StringBuilder stringBuilder = new StringBuilder();
    private AccountType accountType; // 계좌 종류
    private String accountNumber; // 계좌번호
    private String owner; // 소유자
    private BigDecimal balance; // 잔액
    private boolean isActivated; // 활성화 여부
//
//    public BasicAccount(AccountType accountType, String accountNumber, String owner, BigDecimal balance, boolean isActivated) {
//        this.stringBuilder = new StringBuilder();
//        this.accountType = accountType;
//        this.accountNumber = accountNumber;
//        this.owner = owner;
//        this.balance = balance;
//        this.isActivated = isActivated;
//    }
    public String getAccountInfo() {
        stringBuilder.append("[계좌 정보]").append("\n");
        stringBuilder.append("계좌종류: ").append(accountType.getAccountName()).append("\n");
        stringBuilder.append("계좌번호: ").append(getAccountNumber()).append("\n");
        stringBuilder.append("소유자: ").append(getOwner()).append("\n");
        stringBuilder.append("잔액: ").append(getBalance()).append("\n");
        stringBuilder.append("활성여부: ").append(isActivated());
        return stringBuilder.toString();
    }
    public void eraseStringBuilder(){
        this.stringBuilder.setLength(0);
    }

    public void setBalance(BigDecimal balance) {  this.balance = balance;}

    public void withdraw(BigDecimal value) {
        setBalance(balance.subtract((value)));
    }

    public void deposit(BigDecimal value) {
        this.balance=this.balance.add(value);
    }


}