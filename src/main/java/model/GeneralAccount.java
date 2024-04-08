package model;

import lombok.Getter;
import lombok.Setter;
import model.Account;

import java.math.BigDecimal;


@Getter
public class GeneralAccount implements Account {
    protected final String accountType;
    protected final String name;
    protected final String bankAccountNumber;
    @Setter
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
    public String toString() {
        return "계좌종류:'" + accountType + '\'' +
                ", 소유자:'" + name + '\'' +
                ", 계좌번호:'" + bankAccountNumber + '\'' +
                ", 잔액:" + amount +
                ", 활성상태:" + activation;
    }
}
