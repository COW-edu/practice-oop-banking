package bank;

import account.Account;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class BankStorage {

    public static final BankStorage bankStorage = new BankStorage();
    private final Map<String, Account> accounts = new HashMap<>();


    private BankStorage() {

    }

    public static BankStorage getInstance() {
        return bankStorage;
    }

    public String save(Account account, String accountNum) {
        account.setInitAccountNum(accountNum);
        accounts.put(accountNum, account);
        return accountNum;
    }

    public Map<String, Account> getAllAccount() {
        return accounts;
    }
}
