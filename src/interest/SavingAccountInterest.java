package interest;

import java.math.BigDecimal;

public class SavingAccountInterest extends InterestCalculator {

    @Override
    public BigDecimal calculateInterest(BigDecimal amount) {
        return new BigDecimal("1234567");
    }
}
