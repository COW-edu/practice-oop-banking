package bankSevice;

import java.math.BigDecimal;

public class AccountBuilder {
    private String accountType;
    private String name;
    private String bankAccountNumber;
    private BigDecimal amount;
    private boolean activation;
    private BigDecimal goalAmount; // SavingsAccount 에만 해당하는 필드

    public AccountBuilder accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AccountBuilder bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public AccountBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public AccountBuilder activation(boolean activation) {
        this.activation = activation;
        return this;
    }

    public AccountBuilder goalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount;
        return this;
    }

    public GeneralAccount buildGeneralAccount() {
        return new GeneralAccount(accountType, name, bankAccountNumber, amount, activation);
    }

    public SavingsAccount buildSavingsAccount() {
        if (goalAmount == null) {
            throw new IllegalStateException("Goal amount is required for SavingsAccount");
        }
        return new SavingsAccount(accountType, bankAccountNumber, name, amount, activation, goalAmount);
    }
}
