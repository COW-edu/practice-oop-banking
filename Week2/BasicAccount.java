package Week2;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 접근 지정자 변경
public class BasicAccount implements Account {

    private final StringBuilder stringBuilder;

    private AccountType accountType; // 계좌 종류

    private String accountNumber; // 계좌번호

    private String owner; // 소유자

    private BigDecimal balance; // 잔액

    private boolean isActivated; // 활성화 여부


    public BasicAccount(AccountType accountType, String accountNumber, String owner, BigDecimal balance, boolean isActivated) {
        this.stringBuilder = new StringBuilder();
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        this.isActivated = isActivated;
    }
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
//    public AccountType getAccountType() { return accountType;}
    public void setBalance(BigDecimal balance) {  this.balance = balance;}

    public void withdraw(BigDecimal value) {
        setBalance(balance.subtract((value)));
//        this.balance=this.balance.subtract(value);
//        System.out.println("withdraw"+getBalance());
    }

    public void deposit(BigDecimal value) {
        this.balance=this.balance.add(value);
//        System.out.println("deposit"+this.getBalance());
    }

}