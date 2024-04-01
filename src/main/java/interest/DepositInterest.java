package interest;

import java.math.BigDecimal;

public class DepositInterest implements InterestCalculator{
    @Override
    public BigDecimal getInterest(BigDecimal balance) {

        BigDecimal interestRate = DepositInterestRateTier.findInterestRateForBalance(balance);
            return balance.multiply(interestRate);
        }
    }
