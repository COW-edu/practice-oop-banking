package Interest;

import java.math.BigDecimal;

public class DepositInterest implements InterestCalculator{
    @Override
    public BigDecimal getInterest(BigDecimal balance) {
            BigDecimal interestRate;

            if (balance.compareTo(new BigDecimal("10000000")) >= 0) {
                interestRate = new BigDecimal("0.50");  // 50%
            } else if (balance.compareTo(new BigDecimal("5000000")) >= 0) {
                interestRate = new BigDecimal("0.07");  // 7%
            } else if (balance.compareTo(new BigDecimal("1000000")) >= 0) {
                interestRate = new BigDecimal("0.04");  // 4%
            } else if (balance.compareTo(new BigDecimal("10000")) >= 0) {
                interestRate = new BigDecimal("0.02");  // 2%
            } else {
                interestRate = new BigDecimal("0.01");  // 1%
            }

            return balance.multiply(interestRate);
        }
}


