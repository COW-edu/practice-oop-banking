package bank;

import account.Account;

import java.util.HashMap;
import java.util.Map;

public class BankStorage {
    Map<String, Account> accountList= new HashMap<>();

    public String save(Account account){
        accountList.put(account.getAccountId(), account);
        return getAccount(account.getAccountId()).getAccountId();
    }
    public Account getAccount(String accountNum){
        return accountList.get(accountNum);
    }

    public Map<String, Account> getAllAccount(){
        return accountList;
    }
}
