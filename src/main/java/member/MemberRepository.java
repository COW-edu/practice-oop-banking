package member;

import java.math.BigDecimal;

public interface MemberRepository {
    void save(GeneralMember generalMember);
    void addAmount(String accountNumber, BigDecimal depositAmount);

    GeneralMember findByAccountNumber(String accountNumber);
}
