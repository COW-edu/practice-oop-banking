package interest;

import model.Account;

import java.math.BigDecimal;

public interface InterestPolicy {
    BigDecimal interest(Account member);
}
