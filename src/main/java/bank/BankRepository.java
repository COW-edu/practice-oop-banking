package bank;

import java.math.BigDecimal;

public interface BankRepository {
    void save(GeneralMember generalMember);
    void addAmount(String accountNumber, BigDecimal depositAmount);
    void subtractAmount(String accountNumber, BigDecimal withdrawAmount);
    GeneralMember findByAccountNumber(String accountNumber);
}
