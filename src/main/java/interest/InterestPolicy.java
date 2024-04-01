package interest;

import member.GeneralMember;

import java.math.BigDecimal;

public interface InterestPolicy {
    BigDecimal interest(GeneralMember member);
}
