package interest;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BasicAccountInterestRange {
  INTEREST_RANGE_1(BigDecimal.valueOf(100000000)),
  INTEREST_PERCENT_1(BigDecimal.valueOf(0.5)),
  INTEREST_RANGE_2(BigDecimal.valueOf(5000000)),
  INTEREST_PERCENT_2(BigDecimal.valueOf(0.07)),
  INTEREST_RANGE_3 (BigDecimal.valueOf(1000000)),
  INTEREST_PERCENT_3(BigDecimal.valueOf(0.04)),
  INTEREST_RANGE_4(BigDecimal.valueOf(10000)),
  INTEREST_PERCENT_4(BigDecimal.valueOf(0.02)),
  INTEREST_PERCENT_5(BigDecimal.valueOf(0.01));

  final private BigDecimal value;
}
