package Week2;

import java.util.*;
import java.math.BigDecimal;
//  계좌생성, 출금, 입금, 송금 메서드 구현
// 내부에서 입력을 받는 액션?
// 적금 계좌는
public class Bank {
    private ArrayList<Account> accountArray;
    private HashMap<AccountType, InterestCalculator> interestCalculator;

    public Bank(){
        this.accountArray = new ArrayList<>();
        this.interestCalculator = new HashMap<>();
        this.interestCalculator.put(AccountType.NORMAL_ACCOUNT, new NormalInterestCalculator());
        this.interestCalculator.put(AccountType.SAVING_ACCOUNT, new SavingInterestCalculator());
    }

    // 계좌생성
    // 한 메소드안에 NORMAL과 SAVING을 같이 넣을려했지만 매개변수 이슈로 나눔
    public void createAccount(AccountType accountType, String accountNumber, String owner,
                              BigDecimal balance, boolean isActivated ){

        BasicAccount account = new BasicAccount(accountType, accountNumber, owner, balance, isActivated);
        accountArray.add(account);

    }
    public void createAccount(AccountType accountType, String accountNumber, String owner,
                              BigDecimal balance, boolean isActivated,String targetAmount ){

        SavingAccount account = new SavingAccount(accountType, accountNumber, owner, balance, isActivated, targetAmount);
        accountArray.add(account);
    }

    // 입금
    public void deposit(String accountNumber, BigDecimal money){

        for (int i = 0; i < accountArray.size(); i++){
//            System.out.println(i);
            if( accountArray.get(i).getAccountNumber().equals(accountNumber)) {
                accountArray.get(i).deposit(money);
                break;
            }
            if( i == accountArray.size()-1){
                System.out.println(accountNumber+"계좌 없음");
            }
        }

    }
    // 출금
    public void withdraw(String accountNumber, BigDecimal money){
        for (int i = 0; i < accountArray.size(); i++){
            if( accountArray.get(i).getAccountNumber().equals(accountNumber)) {
                accountArray.get(i).withdraw(money);
                break;
            }
            if( i == accountArray.size()-1){
                System.out.println(accountNumber+"계좌 없음");
            }
        }

    }
    // 송금
    public void remittance(String accountNumber, String targetAccountNumber,BigDecimal money){
        int Switch = 0;
        for (int i = 0; i < accountArray.size(); i++){
            if( accountArray.get(i).getAccountNumber().equals(accountNumber)) {
                accountArray.get(i).withdraw(money);
            }
                for (int j = 0; j < accountArray.size(); j++){
                    if( accountArray.get(j).getAccountNumber().equals(targetAccountNumber)) {
                        accountArray.get(j).deposit(money);
                        Switch = 1;
                        break;
                    }
                }
            if (Switch == 1)
                break;


        }
    }

    public void getAccountInfo(String accountNumber){

        for (int i = 0; i < accountArray.size(); i++){
            if( accountArray.get(i).getAccountNumber().equals(accountNumber)) {
                System.out.println(accountArray.get(i).getAccountInfo());
                System.out.println();
                accountArray.get(i).eraseStringBuilder();
                break;
            }
            if( i == accountArray.size()-1){
                System.out.println(accountNumber+"계좌 없음");
            }
        }
    }

//     이자금액 반환
//     계좌번호로 NORMAL인지 SAVING인지 확인
//     확인 후 Type에 맞는 Hashmap 메소드 사용
    public void getInterest(String accountNumber){

        for (int i = 0; i < accountArray.size(); i++){
            if( accountArray.get(i).getAccountNumber().equals(accountNumber)) {
                if( accountArray.get(i).getAccountType().equals(AccountType.NORMAL_ACCOUNT) ){
                    System.out.println("이자금액 : " + this.interestCalculator.get(AccountType.NORMAL_ACCOUNT).getInterest(accountArray.get(i).getBalance()));
                } else if( accountArray.get(i).getAccountType().equals(AccountType.SAVING_ACCOUNT) ){
                    System.out.println("이자금액 : " + this.interestCalculator.get(AccountType.SAVING_ACCOUNT).getInterest(accountArray.get(i).getBalance()));
                }
            }
        }

    }



}
