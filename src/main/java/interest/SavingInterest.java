package interest;

import java.math.BigDecimal;

public class SavingInterest implements InterestCalculator{

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        BigDecimal interestRate = SavingInterestRateTier.findInterestRateForBalance(balance);
        return balance.multiply(interestRate);
    }
}