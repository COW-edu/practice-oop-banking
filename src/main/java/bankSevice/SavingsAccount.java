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

}
