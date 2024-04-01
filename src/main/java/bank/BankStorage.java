package bank;

import account.Account;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class BankStorage {
    private final CentralBank centralBank;
    Map<String, Account> accountList= new HashMap<>();

    public String save(Account account){
        accountList.put(account.getAccountNum(), account);
        centralBank.getAccountList(account.getAccountNum(), account);
        return getAccount(account.getAccountNum()).getAccountNum();
    }
    public Account getAccount(String accountNum){
        return accountList.get(accountNum);
    }

    public Map<String, Account> getAllAccount(){
        return accountList;
    }
}
