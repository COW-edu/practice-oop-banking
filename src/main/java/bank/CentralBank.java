package bank;

import account.Account;

import java.util.HashMap;
import java.util.Map;

public class CentralBank {

    private final BankStorage bankStorage = BankStorage.getInstance();

    public void showAccountList() {
        Map<String, Account> accounts = getAccountList();
        StringBuilder stringBuilder = new StringBuilder();
        accounts.forEach((accountNum, account) ->
                stringBuilder.append(account.getAccountInfo()).append("\n"));
        System.out.println(stringBuilder.toString());
    }

    private Map<String, Account> getAccountList() {
        return bankStorage.getAllAccount();
    }
}
