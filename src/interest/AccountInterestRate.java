package interest;

import accounts.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountInterestRate extends InterestCalculator {

    @Override
    public BigDecimal calculateInterest(BigDecimal amount) {
        if(amount.compareTo(TEN_MILLION) >= 0) {
            return RATE_50;
        } else if (amount.compareTo(FIVE_MILLION) >= 0) {
            return RATE_7;
        } else if (amount.compareTo(ONE_MILLION) >= 0) {
            return RATE_4;
        } else if (amount.compareTo(TEN_THOUSAND) >= 0) {
            return RATE_2;
        } else {
            return RATE_1;
        }
    }
}
