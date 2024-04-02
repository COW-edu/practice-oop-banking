package banking.account.policy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NormalInterestCalculator implements InterestCalculator {

    private final NavigableMap<BigDecimal, BigDecimal> interestRates = new TreeMap<>();

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        initializeInterest();
        BigDecimal rate = calculateInterest(balance);
        return balance.multiply(rate).setScale(0, RoundingMode.DOWN);
    }

    private BigDecimal calculateInterest(BigDecimal balance) {
        Map.Entry<BigDecimal, BigDecimal> entry = interestRates.floorEntry(balance);
        if (entry == null) {
            return BigDecimal.valueOf(0.01);
        }
        return entry.getValue();
    }

    private void initializeInterest() {
        if (interestRates.isEmpty()) {
            interestRates.put(BigDecimal.valueOf(10_000), BigDecimal.valueOf(0.02));
            interestRates.put(BigDecimal.valueOf(1_000_000), BigDecimal.valueOf(0.04));
            interestRates.put(BigDecimal.valueOf(5_000_000), BigDecimal.valueOf(0.07));
            interestRates.put(BigDecimal.valueOf(10_000_000), BigDecimal.valueOf(0.5));
        }
    }
}
