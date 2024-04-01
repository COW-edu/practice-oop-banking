package bank;

import account.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CentralBank {


    private Map<String, Account> accountList= new HashMap<>();
    public void getAccountList(String accountNum, Account account) {
        accountList.put(accountNum, account);
    }
    public void showAccountList(){
        accountList.forEach((accountNum, account) ->
                System.out.println(account.getAccountInfo())
        );
    }
}
