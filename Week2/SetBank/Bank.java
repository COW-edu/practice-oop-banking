package Week2.SetBank;

import Week2.Account.Account;
import Week2.Account.AccountType;
import Week2.Account.BasicAccount;
import Week2.Account.SavingAccount;
import Week2.InterestCalculator.InterestCalculator;
import Week2.InterestCalculator.NormalInterestCalculator;
import Week2.InterestCalculator.SavingInterestCalculator;

import java.util.*;
import java.math.BigDecimal;

public class Bank extends InputAccount {
    private ArrayList<Account> accounts = new ArrayList<>();
    private HashMap<AccountType, InterestCalculator> interestCalculator = new HashMap<>();

    public Bank(){
        this.interestCalculator.put(AccountType.NORMAL_ACCOUNT, new NormalInterestCalculator());
        this.interestCalculator.put(AccountType.SAVING_ACCOUNT, new SavingInterestCalculator());
        System.out.println("Bank생성자");
    }

    public void createBasicAccount( ){

        AccountType accountType = AccountType.NORMAL_ACCOUNT;
        String accountNumber = this.inputAccountNumber();
        String owner = this.inputOwner();
        BigDecimal balance = this.inputBalance();
        boolean isActivated = this.inputIsActivated();

        BasicAccount account = new BasicAccount(accountType, accountNumber, owner, balance, isActivated);
        accounts.add(account);
    }
    public void createSavingAccount(){

        AccountType accountType = AccountType.SAVING_ACCOUNT;
        String accountNumber = this.inputAccountNumber();
        String owner = this.inputOwner();
        BigDecimal balance = this.inputBalance();
        boolean isActivated = this.inputIsActivated();
        BigDecimal targetAmount = this.inputTargetAmount();

        SavingAccount account = new SavingAccount(accountType, accountNumber, owner, balance, isActivated, targetAmount);
        accounts.add(account);
    }

    // 입금
    public void deposit(String accountNumber, BigDecimal money){

        boolean success = false;

        for( Account account : accounts){
            if( account.getAccountNumber().equals(accountNumber) ) {
                account.deposit(money);
                success = true;
                break;
            }
        }
        if( !success ){
            System.out.println("계좌 없음");
        }
    }
    // 출금
    public void withdraw(String accountNumber, BigDecimal money){

        boolean success = false;

        for( Account account : accounts){
            if( account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(money);
                success = true;
                break;
            }
        }
        if( !success ){
            System.out.println("계좌 없음");
        }
    }
    // 송금
    public void remittance(String accountNumber, String targetAccountNumber,BigDecimal money) {

        boolean balance_A = false; // 출금계좌의 돈이 충분한지
        boolean find_A = false; // 출금계좌 존재여부
        boolean find_B = false; // 입금계좌 존재여부
        boolean isActivated_A = false;
        boolean isActivated_B= false;

        Account A = null; // 출금계좌 정보담음
        Account B = null; // 입금계좌 정보담음

        // 양쪽 계좌가 존재하면서 송금하는 계좌의 돈이 충분해야 송금이 가능하도록
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                A = account;
                find_A = true;
                if( account.getBalance().compareTo(money) >= 0 ){
                    balance_A = true;
                }
                break;
            }
        }
        if( isActivated_A ) {
            return;
        }

        if( !balance_A ){
            System.out.println("출금 계좌 잔액 부족");
            return;
        } else if( !find_A ){
            System.out.println("출금 계좌 검색 실패");
            return;
        }

        if (find_A) {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(targetAccountNumber)) {
                    B=account;
                    find_B = true;
                    break;
                }
            }
        }

        if( isActivated_B ){
            return;
        }
        if( !find_B ){
            System.out.println("입금 계좌 검색 실패");
            return;
        }

        if( find_A && find_B){
            A.withdraw(money);
            B.deposit(money);
            System.out.println("이체 성공");
        }
    }
    public void getAccountInfo(String accountNumber){
        for(Account account : accounts ){
            if(account.getAccountNumber().equals(accountNumber) ){
                System.out.println(account.getAccountInfo());
                System.out.println();
                account.eraseStringBuilder();
                break;
            }
        }
    }

    public void getInterest(String accountNumber){

        for( Account account : accounts ){
            if(account.getAccountNumber().equals(accountNumber) ){
                if(account.getAccountType().equals(AccountType.NORMAL_ACCOUNT)){
                    System.out.println("이자금액 : " + this.interestCalculator.get(AccountType.NORMAL_ACCOUNT).getInterest(account.getBalance()));
                } else {
                    System.out.println("이자금액 : " + this.interestCalculator.get(AccountType.SAVING_ACCOUNT).getInterest(account.getBalance()));
                }
            }
        }
    }

    public Integer isHaveAccount(){

        int isHave = accounts.size();

        return isHave;
    }

    public boolean IsActivated(String accountNumber) {

        for( Account account : accounts ) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.isActivated() == true) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
