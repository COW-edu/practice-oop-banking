package interest;

import bank.GeneralMember;

import java.math.BigDecimal;

public interface InterestPolicy {
    BigDecimal interest(GeneralMember member);
}
