package Interest;

import java.math.BigDecimal;

public class SavingInterest implements InterestCalculator{


    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        BigDecimal interestRate;

        if (balance.compareTo(new BigDecimal("10000000")) >= 0) {
            interestRate = new BigDecimal("0.50");
            return balance.multiply(interestRate);
        }
            interestRate = new BigDecimal("0.01");
            return balance.multiply(interestRate);
    }
}