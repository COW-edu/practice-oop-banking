package interest;

import java.math.BigDecimal;

public class InstallmentSavingsInterest implements InterestCalculator {

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        BigDecimal interestRate = InstallmentSavingsInterestRateTier.findInterestRateForBalance(balance);
        return balance.multiply(interestRate);
    }
}