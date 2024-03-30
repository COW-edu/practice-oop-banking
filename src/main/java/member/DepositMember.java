package member;

import java.math.BigDecimal;

public class DepositMember {
    private String accountType;
    private String name;
    private String bankAccountNumber;
    private BigDecimal amount;
    private boolean activation;

    public DepositMember(String accountType, String name, String bankAccountNumber, BigDecimal amount, boolean activation) {
        this.accountType = accountType;
        this.name = name;
        this.bankAccountNumber = bankAccountNumber;
        this.amount = amount;
        this.activation = activation;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }
}
