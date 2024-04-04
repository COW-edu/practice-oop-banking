package bankSevice;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class GeneralAccount {
    private String accountType;
    private String name;
    private String bankAccountNumber;
    private BigDecimal amount;
    private boolean activation;

    public GeneralAccount(String accountType, String name, String bankAccountNumber, BigDecimal amount, boolean activation) {
        this.accountType = accountType;
        this.name = name;
        this.bankAccountNumber = bankAccountNumber;
        this.amount = amount;
        this.activation = activation;
    }

}
