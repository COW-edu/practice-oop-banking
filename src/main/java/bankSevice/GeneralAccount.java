package bankSevice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
public class GeneralAccount implements Account {
    private final String accountType;
    private final String name;
    private final String bankAccountNumber;
    @Setter
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
