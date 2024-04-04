package interest;

import bankSevice.GeneralAccount;

import java.math.BigDecimal;

public interface InterestPolicy {
    BigDecimal interest(GeneralAccount member);
}
