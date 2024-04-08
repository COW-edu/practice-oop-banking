package BankRepository;

import bankSevice.Account;

import java.math.BigDecimal;

public interface BankRepository {
    void save(Account generalAccount);
    Account getAccount(String accountNumber);
}
