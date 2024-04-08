package bank;

import account.Account;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankStorage {

    public static final BankStorage bankStorage = new BankStorage();
    private final Map<String, Account> accounts = new HashMap<>();

    public static BankStorage getInstance() {
        return bankStorage;
    }

    public String save(Account account) {
        accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    // public Optional<Account> findByAccountNumber(String accountNumber) {
    //    return Optional.ofNullable(accounts.get(accountNumber));
    //}

    public Map<String, Account> getAllAccount() {
        return accounts;
    }
}
