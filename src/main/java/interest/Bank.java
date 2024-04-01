package interest;

import java.math.BigDecimal;

public class Bank {

    private BigDecimal InterestAmount;

    public Bank(BigDecimal interestAmount) {
        InterestAmount = interestAmount;
    }

    public BigDecimal getInterestAmount() {
        return InterestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        InterestAmount = interestAmount;
    }
}
