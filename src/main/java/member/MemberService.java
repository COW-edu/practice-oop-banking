package member;

import java.math.BigDecimal;

public interface MemberService {
    void join(GeneralMember generalMember);
    void deposit(String accountNumber, BigDecimal depositAmount);
    GeneralMember getAccountInfo(String accountNumber);



}
