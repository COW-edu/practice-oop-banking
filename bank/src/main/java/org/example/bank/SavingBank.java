package org.example.bank;


import org.example.account.SavingAccount;
import org.example.constant.ErrorCode;
import org.example.exception.WithdrawException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class SavingBank extends Bank {


    public void withdraw(SavingAccount account) throws WithdrawException {
        // Account의 출금 메서드를 조금 다르게 구현

        //적금 계좌는 적금 계좌는 잔액이 목표 금액(%s원) 이상이어야 출금 가능하도록 상속받은 출금 메서드를 조금 다르게 구현해줍니다.

        BigDecimal goalAmount = account.getGoalAmount();

        //돈이 부족하다면.
        if(account.getBalance().compareTo(goalAmount) < 0){
            //enum으로 선언해준 104>>>>>>>>> E104("E104", "적금 계좌는 잔액이 목표 금액(%s원) 이상이어야 출금 가능합니다."),
            throw new WithdrawException("적금 계좌는 잔액이 목표금액 이상이어야 합니다.");
        }
    }

}
