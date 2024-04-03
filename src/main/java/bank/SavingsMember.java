package bank;

import java.math.BigDecimal;

public class SavingsMember extends GeneralMember {
    private BigDecimal goalAmount;
    public SavingsMember(String accountType, String bankAccountNumber, String name, BigDecimal ammount, boolean activation, BigDecimal goalAmount) {
        super(accountType, bankAccountNumber, name, ammount, activation);
        this.goalAmount = goalAmount;
    }
    public BigDecimal getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount;
    }
}
