package Week2;

import java.util.*;
import java.math.BigDecimal;
//  계좌생성, 출금, 입금, 송금 메서드 구현
// 내부에서 입력을 받는 액션?
// 적금 계좌는
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

        for( Account account : accounts){
            if( account.getAccountNumber().equals(accountNumber) ) {
                account.deposit(money);
                break;
            }
        }
    }
    // 출금
    public void withdraw(String accountNumber, BigDecimal money){

        for( Account account : accounts){
            if( account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(money);
                break;
            }
        }
    }
    // 송금
    public void remittance(String accountNumber, String targetAccountNumber,BigDecimal money){
        int Switch = 0;

        // 양쪽 계좌가 존재하면서 송금하는 계좌의 돈이 충분해야 송금이 가능하도록
        for( Account account : accounts ){
            if( account.getAccountNumber().equals(accountNumber) ){
                account.withdraw(money);
            }
        }

        for (int i = 0; i < accounts.size(); i++){
            if( accounts.get(i).getAccountNumber().equals(accountNumber)) {
                accounts.get(i).withdraw(money);
            }
                for (int j = 0; j < accounts.size(); j++){
                    if( accounts.get(j).getAccountNumber().equals(targetAccountNumber)) {
                        accounts.get(j).deposit(money);
                        Switch = 1;
                        break;
                    }
                }
            if (Switch == 1) {
                break;
            }
        }
    }

    // 1. 송금 2. 출금 3. 계좌찾기 이런식으로해서 해야할듯
    // 3누르면 계좌번호 입력하라고뜨고 그 계좌번호를 가지고있는 account찾아서 정보 출력

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

//     이자금액 반환
//     계좌번호로 NORMAL인지 SAVING인지 확인
//     확인 후 Type에 맞는 Hashmap 메소드 사용
    public void getInterest(String accountNumber){


        // 이것도 정리해서 코드 작성
//        for( Account account : accounts ){
//
//
//
//        }


        for (int i = 0; i < accounts.size(); i++){
            if( accounts.get(i).getAccountNumber().equals(accountNumber)) {
                if( accounts.get(i).getAccountType().equals(AccountType.NORMAL_ACCOUNT) ){
                    System.out.println("이자금액 : " + this.interestCalculator.get(AccountType.NORMAL_ACCOUNT).getInterest(accounts.get(i).getBalance()));
                } else if( accounts.get(i).getAccountType().equals(AccountType.SAVING_ACCOUNT) ){
                    System.out.println("이자금액 : " + this.interestCalculator.get(AccountType.SAVING_ACCOUNT).getInterest(accounts.get(i).getBalance()));
                }
            }
        }

    }



}
