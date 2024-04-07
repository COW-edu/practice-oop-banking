package interest;

import accounts.Account;

import java.math.BigDecimal;

public class SavingAccountInterestRate extends InterestCalculator {

    @Override
    public BigDecimal calculateInterest(BigDecimal amount) {
        if(amount.compareTo(ONE_MILLION) >= 0) {
            return RATE_50;
        } else {
            return RATE_1;
        }
    }
}
