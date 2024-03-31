package banking.account.policy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingInterestCalculator implements InterestCalculator {

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        BigDecimal interestRate = balance.compareTo(BigDecimal.valueOf(1000000)) >= 0
                ? BigDecimal.valueOf(0.5)
                : BigDecimal.valueOf(0.01);
        return balance.multiply(interestRate).setScale(0, RoundingMode.DOWN);
    }
}
