package bank;

import java.math.BigDecimal;

public interface BankService {
    void join(GeneralMember generalMember);
    void deposit(String accountNumber, BigDecimal depositAmount);
    void withdraw(String accountNumber, BigDecimal withdrawAmount);
    GeneralMember getAccountInfo(String accountNumber);



}
