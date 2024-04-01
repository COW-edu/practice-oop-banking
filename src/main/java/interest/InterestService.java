package interest;

import java.math.BigDecimal;

public interface InterestService {
    BigDecimal getInterestEstimated(String accountNumber);
}
