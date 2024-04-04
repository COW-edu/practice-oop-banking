package BankRepository;

import bankSevice.GeneralAccount;

import java.math.BigDecimal;

public interface BankRepository {
    void save(GeneralAccount generalAccount);
    void addAmount(String accountNumber, BigDecimal depositAmount);
    void subtractAmount(String accountNumber, BigDecimal withdrawAmount);
    GeneralAccount findByAccountNumber(String accountNumber);
}
