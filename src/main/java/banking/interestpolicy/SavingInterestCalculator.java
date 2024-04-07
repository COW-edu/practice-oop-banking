package banking.interestpolicy;

import banking.constant.SavingInterestRateTier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

public class SavingInterestCalculator implements InterestCalculator {

  @Override
  public BigDecimal getInterest(BigDecimal balance) {
    BigDecimal interestRate = Arrays.stream(SavingInterestRateTier.values())
        .filter(tier -> balance.compareTo(tier.getMinimumBalance()) >= 0)
        .max(Comparator.comparing(SavingInterestRateTier::getMinimumBalance))
        .orElse(SavingInterestRateTier.DEFAULT)
        .getInterestRate();

    return balance.multiply(interestRate).setScale(0, RoundingMode.DOWN);
  }
}
