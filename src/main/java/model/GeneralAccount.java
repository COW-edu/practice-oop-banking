package model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static util.ErrorMessage.NOT_ENOUGH_MONEY;



public class GeneralAccount implements Account {
    protected final String accountType;
    protected final String name;
    @Getter
    protected final String bankAccountNumber;
    @Getter
    protected BigDecimal amount;
    protected boolean activation;

    public GeneralAccount(String accountType, String name, String bankAccountNumber, BigDecimal amount, boolean activation) {
        this.accountType = accountType;
        this.name = name;
        this.bankAccountNumber = bankAccountNumber;
        this.amount = amount;
        this.activation = activation;
    }

    @Override
    public void deposit(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }
    @Override
    public void withdraw(BigDecimal amount) {
        if (this.amount.compareTo(amount) < 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY.getMessage()); // 잔액 부족
        }
        this.amount = this.amount.subtract(amount);
    }

    @Override
    public String toString() {
        return "계좌종류:'" + accountType + '\'' +
                ", 소유자:'" + name + '\'' +
                ", 계좌번호:'" + bankAccountNumber + '\'' +
                ", 잔액:" + amount +
                ", 활성상태:" + activation;
    }
}
