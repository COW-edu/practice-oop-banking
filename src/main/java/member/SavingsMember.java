package member;

import java.math.BigDecimal;

public class SavingsMember extends DepositMember {
    private BigDecimal goalAmount;

    public SavingsMember(int accountType, int bankAccountNumber, String name, BigDecimal ammount, boolean activation, BigDecimal goalAmount) {
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
