package banking.account.policy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NormalInterestCalculator implements  InterestCalculator{

    private final NavigableMap<BigDecimal, BigDecimal> interestRates = new TreeMap<>();

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        calculator();
        BigDecimal rate = (interestRates != null) ? interestRates.floorEntry(balance).getValue(): BigDecimal.ZERO;
        return balance.multiply(rate).setScale(0, RoundingMode.DOWN);
    }

    public void calculator() {
        interestRates.put(BigDecimal.valueOf(10000), BigDecimal.valueOf(0.02));
        interestRates.put(BigDecimal.valueOf(1000000), BigDecimal.valueOf(0.04));
        interestRates.put(BigDecimal.valueOf(5000000), BigDecimal.valueOf(0.07));
        interestRates.put(BigDecimal.valueOf(10000000), BigDecimal.valueOf(0.5));
    }



}
