package BankRepository;

import model.Account;

public interface BankRepository {
    void save(Account generalAccount);
    Account getAccount(String accountNumber);
}
