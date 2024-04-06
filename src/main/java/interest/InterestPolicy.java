package interest;

import bankSevice.Account;

import java.math.BigDecimal;

public interface InterestPolicy {
    BigDecimal interest(Account member);
}
