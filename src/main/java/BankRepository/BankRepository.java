package BankRepository;

import bankSevice.Account;

import java.math.BigDecimal;

public interface BankRepository {
    void save(Account generalAccount);
    void addAmount(String accountNumber, BigDecimal depositAmount);
    void subtractAmount(String accountNumber, BigDecimal withdrawAmount);
    Account findByAccountNumber(String accountNumber);
}
