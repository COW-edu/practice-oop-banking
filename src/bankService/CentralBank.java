package bankService;

import accounts.Account;
import accounts.NormalAccount;
import accounts.SavingAccount;
import interest.AccountInterestRate;
import interest.InterestCalculator;
import interest.SavingAccountInterestRate;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CentralBank {
    private List<Account> accounts;
    private Map<String, InterestCalculator> Calcualateinterest;
    private Pattern pattern = Pattern.compile("\\d{6}-\\d{2}-\\d{6}");
    public CentralBank() {
        accounts = new ArrayList<>();
        Calcualateinterest = new HashMap<>();
        Calcualateinterest.put("N", new AccountInterestRate());
        Calcualateinterest.put("S", new SavingAccountInterestRate());
    }

    public void createNormalAccount(String name, String accountNum, String accountType, BigDecimal amount) {
        Matcher m = pattern.matcher(accountNum);
        // 입력값이 유효한지 확인합니다.
        if ( !m.matches() || amount == null
                || amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Wrong Input Value. Failed Create Account");
            return;
        }
        // 계좌를 생성하고 리스트에 추가합니다.
        Account normalAccount = new NormalAccount(name, accountNum, accountType, amount);
        accounts.add(normalAccount);
        System.out.println("Successfully Create Normal Account!");
    }

    public void createSavingAccount(String name, String accountNum, String accountType, BigDecimal currentAmount, BigDecimal goalAmount) {
        Matcher m = pattern.matcher(accountNum);
        // 입력값이 유효한지 확인합니다.
        if ( !m.matches() || currentAmount == null || goalAmount == null
                || currentAmount.compareTo(BigDecimal.ZERO) < 0 || goalAmount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Wrong Input Value. Failed Create Account");
            return;
        }
        // 계좌를 생성하고 리스트에 추가합니다.
        Account savingAccount = new SavingAccount(name, accountNum, accountType, currentAmount, goalAmount);
        accounts.add(savingAccount);
        System.out.println("Successfully Create Saving Account!");
    }

    public void transfer(String senderAccountNum, String receiverAccountNum, BigDecimal sendAmount) { // 송금
        Account sender = null;
        Account receiver = null;

        for(Account account : accounts){
            if(account.isExist(senderAccountNum)){
                sender = account;
            }
            if(account.isExist(receiverAccountNum)){
                receiver = account;
            }
        }

        if(sender != null && receiver != null){
            if(sender.withdraw(sendAmount)) {
                receiver.deposit(sendAmount);
            } else {
                System.out.println("Failed Transfer! Insufficient balance ");
            }
        } else {
            System.out.println("Failed Transfer! Sender or Receiver is not Available");
        }
    }

    public void withDraw(String accountNum, BigDecimal amount) {
        accounts.stream()
                .filter(a -> a.isExist(accountNum))
                .forEach(a -> a.withdraw(amount));
    }

    public void deposite(String accountNum, BigDecimal amount) {
        accounts.stream()
                .filter(a -> a.isExist(accountNum))
                .forEach(a -> a.deposit(amount));
    }

    public void printAccountInfo(String accountNum){
        for (Account a : accounts) {
            if (a.isExist(accountNum)) {
                System.out.println(a.getAccountInfo());
            }
        }
    }
}
