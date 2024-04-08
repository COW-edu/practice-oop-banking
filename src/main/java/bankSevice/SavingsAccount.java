package bankSevice;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class SavingsAccount extends GeneralAccount {
   private final BigDecimal goalAmount;

    public SavingsAccount(String accountType, String bankAccountNumber, String name, BigDecimal amount, boolean activation, BigDecimal goalAmount) {
        super(accountType, bankAccountNumber, name, amount, activation);
        this.goalAmount = goalAmount;
    }
    @Override
    public String toString() {
        return "계좌종류:'" + accountType + '\'' +
                ", 소유자:'" + name + '\'' +
                ", 계좌번호:'" + bankAccountNumber + '\'' +
                ", 잔액:" + amount +
                ", 활성상태:" + activation +
                ", 목표금액:" + goalAmount ;
    }
}
