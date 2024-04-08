package banking.constant;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public enum SavingInterestRateTier {

  TIER(BigDecimal.valueOf(1_000_000), BigDecimal.valueOf(0.5)),
  DEFAULT(BigDecimal.ZERO, BigDecimal.valueOf(0.01));

  private final BigDecimal minimumBalance;
  private final BigDecimal interestRate;

  SavingInterestRateTier(BigDecimal minimumBalance, BigDecimal interestRate) {
    this.minimumBalance = minimumBalance;
    this.interestRate = interestRate;
  }
}
