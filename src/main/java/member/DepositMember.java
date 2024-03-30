package member;

import java.math.BigDecimal;

public class DepositMember {
    private int accountType;
    private int bankAccountNumber;
    private String name;
    private BigDecimal ammount;
    private boolean activation;

    public DepositMember(int accountType, int bankAccountNumber, String name, BigDecimal ammount, boolean activation) {
        this.accountType = accountType;
        this.bankAccountNumber = bankAccountNumber;
        this.name = name;
        this.ammount = ammount;
        this.activation = activation;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public boolean isActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }
}
