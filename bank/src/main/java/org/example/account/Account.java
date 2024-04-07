package org.example.account;

import org.example.exception.WithdrawException;

import java.math.BigDecimal;

public class Account {
    //필요한 정보 : 일반 계좌 클래스의 속성은 종류 2가지 ( 1. N 예금계좌 , 2. S 적금계좌)
    //계좌번호, 소유자, 잔액, 활성화 여부

    protected String category; //계좌 종류
    protected String accountNum; //계좌번호
    protected String owner; // 소유자
    protected BigDecimal balance; //잔액
    protected boolean isVaild; // 활성화 여부

    //적금 계좌 클래스는 일반 예금 계좌 클래스에서 상속을 받고 목표 금액 속성이 추가 .
    // 이 클래스는 일반 계좌 즉 n을 뜻한다.
    public Account() {
        //활성화 여부와 계좌 종류를 명시한다
        isVaild = true;
        category = "Normal";
    }

    //두번째 생성자에는 계좌번호와 소유자, 잔액을 표기한다.
    public Account(String accountNum, String owner, BigDecimal balance) {
        //생성자 체이닝을 활용하여, 위의 account()의 내용도 같이 선언해준다.
        this();
        this.accountNum = accountNum;
        this.owner = owner;
        this.balance = balance;

    }

    //getter & setter part - 접근 지정자가 protected 이기 때문에
    public String getaccountNum() {
        return accountNum;
    }

    public void setAccNo(String acccountNum) {
        this.accountNum = acccountNum;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public boolean isVaild() {
        return isVaild;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //필요한 계좌정보를 불러내는 메서드
    public void getAccountInfo() {
        System.out.println("-------------------------");
        System.out.println("계좌의 종류 : "+category);
        System.out.println("계좌번호 : "+accountNum );
        System.out.println("계좌주 : "+owner);
        System.out.println("잔액 : "+balance);
    }


    // 뱅크 클래스에서 호출할 출금, 입금 기본 메서드를 생성합니다.

    //출금 관련 메서드 withdraw
    public BigDecimal withdraw(BigDecimal amount) throws WithdrawException {
        //계좌의 잔액이 출금하고자 하는 금액보다 낮다면 ( 에러 던지기)
        if(this.balance.compareTo(amount) < 0){
            throw new WithdrawException("잔액이 모자랍니다.");
        }else{

            //subtract 함수는 빼는 함수이다.
            //This.balance -amount .
            this.balance = this.balance.subtract(amount);
        }
        return amount;
    }



    //입금 관련 메서드 deposit



    //equals overriding



    // hashcode overriding













}
