package interest;

import java.math.BigDecimal;

public enum InterestList {
    OVERTHOUSAND(10000000, 0.5, 0.5),
    OVERFIVEHUNDRED(5000000, 0.07, 0.5),
    OVERHUNDRED(1000000, 0.04, 0.5),
    OVERONE(10000, 0.02, 0.01),
    REMAIN(0, 0.01, 0.01);

    private final BigDecimal accountAmount;
    private final BigDecimal generalAccountInterest;
    private final BigDecimal savingsAccountInterest;

    InterestList(int accountAmount, double generalAccountInterest, double savingsAccountInterest) {
        this.accountAmount = BigDecimal.valueOf(accountAmount);
        this.generalAccountInterest = BigDecimal.valueOf(generalAccountInterest);
        this.savingsAccountInterest = BigDecimal.valueOf(savingsAccountInterest);
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public BigDecimal getGeneralAccountInterest() {
        return generalAccountInterest;
    }

    public BigDecimal getSavingsAccountInterest() {
        return savingsAccountInterest;
    }
}