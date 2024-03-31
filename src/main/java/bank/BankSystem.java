package bank;

import account.Account;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BankSystem {

    private final BankStorage bankStorage;

    public BankSystem(BankStorage bankStorage){
        this.bankStorage = bankStorage;
    }
    public String createAccount(Account account) {
        String accountNum = createAccountNum();
        account.setAccountNum(accountNum);
        return bankStorage.save(account);

    }

    public String deposit(String accountNum, BigDecimal balance) {
        System.out.println(bankStorage);
        Map<String, Account> allList = getAllList();
        Account account = allList.get(accountNum);
        return account.deposit(balance);
    }

    public String withdraw(String accountNum, BigDecimal balance) {
        System.out.println(bankStorage);
        Map<String, Account> allList = getAllList();
        Account account = allList.get(accountNum);
        return account.withdraw(balance);
    }
    public String remittance(String fromAccountNum, String toAccountNum, BigDecimal balance) {
        Map<String, Account> allList = getAllList();
        Account toAccount = allList.get(fromAccountNum);
        Account fromAccount = allList.get(toAccountNum);

        String message = toAccount.withdrawForTransfer(balance);
        fromAccount.depositForTransfer(balance);
        return message;
    }
    public String changeStatus(String accountNum) {
        Map<String, Account> allList = getAllList();
        Account account = allList.get(accountNum);
        return account.changeStatus();
    }
    private String createAccountNum(){
        return Long.toString(ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L));
    }
    private Map<String, Account> getAllList(){
       return bankStorage.getAllAccount();
    }

    private boolean validateStatus(){

    }
}
