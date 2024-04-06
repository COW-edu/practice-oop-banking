package interest;

import java.math.BigDecimal;

public class SavingsInterest implements InterestCalculator {
    @Override
    public BigDecimal getInterest(BigDecimal balance) {

        BigDecimal interestRate = SavingsInterestRateTier.findInterestRateForBalance(balance);
        return balance.multiply(interestRate);
    }
}
