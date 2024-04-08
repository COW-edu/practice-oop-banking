package banking.interestpolicy;

import banking.constant.BasicInterestRateTier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

public class NormalInterestCalculator implements InterestCalculator {

  @Override
  public BigDecimal getInterest(BigDecimal balance) {
    BigDecimal interestRate = Arrays.stream(BasicInterestRateTier.values())
        .filter(tier -> balance.compareTo(tier.getMinimumBalance()) >= 0)
        .max(Comparator.comparing(BasicInterestRateTier::getMinimumBalance))
        .orElse(BasicInterestRateTier.DEFAULT)
        .getInterestRate();

    return balance.multiply(interestRate).setScale(0, RoundingMode.DOWN);
  }
}
