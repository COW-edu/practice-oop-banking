package BankRepository;

import model.Account;

import java.util.HashMap;
import java.util.Map;

public class BankMemoryRepository implements BankRepository {
    private static final Map<String, Account> store = new HashMap<>();
    @Override
    public void save(Account account) {
        store.put(account.getBankAccountNumber(), account);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return store.get(accountNumber);
    }
}

