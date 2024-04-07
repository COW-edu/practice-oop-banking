package banking.constant;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public enum BasicInterestRateTier {

  TIER_1(BigDecimal.valueOf(10_000), BigDecimal.valueOf(0.02)),
  TIER_2(BigDecimal.valueOf(1_000_000), BigDecimal.valueOf(0.04)),
  TIER_3(BigDecimal.valueOf(5_000_000), BigDecimal.valueOf(0.07)),
  TIER_4(BigDecimal.valueOf(10_000_000), BigDecimal.valueOf(0.5)),
  DEFAULT(BigDecimal.ZERO, BigDecimal.valueOf(0.01)); // 기본 이자율

  private final BigDecimal minimumBalance;
  private final BigDecimal interestRate;

  BasicInterestRateTier(BigDecimal minimumBalance, BigDecimal interestRate) {
    this.minimumBalance = minimumBalance;
    this.interestRate = interestRate;
  }
}
