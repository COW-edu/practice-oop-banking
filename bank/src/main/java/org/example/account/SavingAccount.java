package org.example.account;


import java.math.BigDecimal;


//적금 계좌 클래스는 일반 예금 계좌 클래스에서 상속을 받고 목표 금액 속성이 추가 됩니다.


public class SavingAccount extends Account {


    //천만원으로 목표 금액 설정
    private BigDecimal goalPrice = new BigDecimal(10000000);


    public SavingAccount(){
        super();
        this.category = "Saving";
    }
    // 적금 계좌의 카테고리를 "Saving"로 만들어 줍니다.
    public SavingAccount(String accNo, String owner, BigDecimal balance, BigDecimal goalAmount) {
        super(accNo, owner, balance);
        this.goalPrice = goalAmount;
        this.category = "Saving";
    }

    public BigDecimal getGoalAmount() {
        return goalPrice;
    }

    @Override
    public void getAccountInfo() {
        System.out.println("-------------------------");
        System.out.println("계좌의 종류 : "+category);
        System.out.println("계좌번호 : "+accountNum );
        System.out.println("계좌주 : "+owner);
        System.out.println("잔액 : "+balance);
        System.out.println("목표 금액 : "+goalPrice);
    }



}
