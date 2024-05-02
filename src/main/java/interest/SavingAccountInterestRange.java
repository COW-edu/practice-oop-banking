package interest;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SavingAccountInterestRange {
  INTEREST_RANGE_1(BigDecimal.valueOf(1000000)),
  INTEREST_PERCENT_1(BigDecimal.valueOf(0.5)),
  INTEREST_PERCENT_2(BigDecimal.valueOf(0.01));

  private final BigDecimal value;
}
