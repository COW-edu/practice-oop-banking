package bank;

import account.Account;
import account.AccountType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BankSystem {

    BankStorage bankStorage;

    public BankSystem(BankStorage bankStorage){
        this.bankStorage = bankStorage;
    }
    public String createAccount(Account account) {
        String accountNum = createAccountNum();
        account.setAccountNum(accountNum);
        return bankStorage.save(account);

    }
    public String deposit(String accountNum, BigDecimal balance) {

        Map<String, Account> allList = getAllList();
        Account account = allList.get(accountNum);
        return account.deposit(balance);
    }

    public void withdraw() {

    }

    public void remittance(String fromAccountNum, String toAccountNum, BigDecimal balance) {

    }

    private String createAccountNum(){
        return Long.toString(ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L));
    }
    private Map<String, Account> getAllList(){
       return bankStorage.getAllAccount();
    }

}
