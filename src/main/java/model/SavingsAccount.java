package model;

import lombok.Getter;
import model.GeneralAccount;

import java.math.BigDecimal;

import static util.ErrorMessage.FAIL_TO_GOAL;
import static util.ErrorMessage.NOT_ENOUGH_MONEY;


@Getter
public class SavingsAccount extends GeneralAccount {
   private final BigDecimal goalAmount;

    public SavingsAccount(String accountType, String bankAccountNumber, String name, BigDecimal amount, boolean activation, BigDecimal goalAmount) {
        super(accountType, bankAccountNumber, name, amount, activation);
        this.goalAmount = goalAmount;
    }
    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        // 목표 금액에 도달했는지 확인
        if (this.amount.compareTo(goalAmount) < 0 ) {
            throw new IllegalArgumentException(FAIL_TO_GOAL.getMessage());
        }
        if(this.amount.compareTo(amount) < 0){
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY.getMessage());
        }
        this.amount = this.amount.subtract(amount);

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
