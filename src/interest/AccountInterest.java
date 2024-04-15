package interest;

import java.math.BigDecimal;

public class AccountInterest extends InterestCalculator {
    @Override
    public BigDecimal calculateInterest(BigDecimal amount) {
        return new BigDecimal("123456");
    }
}
