package org.example.account;
import java.util.HashMap;
import java.util.Map;
public class AccountManager {
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNum(), account);
    }




}
