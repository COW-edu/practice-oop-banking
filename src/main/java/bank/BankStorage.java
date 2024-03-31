package bank;

import account.Account;

import java.util.HashMap;
import java.util.Map;

public class BankStorage {
    CentralBank centralBank;
    Map<String, Account> accountList= new HashMap<>();

    public BankStorage(CentralBank centralBank) {
        this.centralBank = centralBank;
    }

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
