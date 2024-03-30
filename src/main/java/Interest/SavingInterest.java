package Interest;

import java.math.BigDecimal;

public class SavingInterest implements InterestCalculator{


    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        BigDecimal interestRate;

        if (balance.compareTo(new BigDecimal("10000000")) >= 0) {
            interestRate = new BigDecimal("0.50");  // 50%
            return balance.multiply(interestRate);
        }
        if (balance.compareTo(new BigDecimal("5000000")) >= 0) {
            interestRate = new BigDecimal("0.01");  // 1%
            return balance.multiply(interestRate);
        }
        return null;
    }
}