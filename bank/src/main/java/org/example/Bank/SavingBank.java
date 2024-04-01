package org.example.Bank;


import org.example.Account.savingAccount;
import org.example.Constant.ErrorCode;
import org.example.Exception.WithdrawException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class SavingBank extends Bank {


    public void withdraw(savingAccount account) throws WithdrawException {
        // Account의 출금 메서드를 조금 다르게 구현

        //적금 계좌는 적금 계좌는 잔액이 목표 금액(%s원) 이상이어야 출금 가능하도록 상속받은 출금 메서드를 조금 다르게 구현해줍니다.

        BigDecimal goalAmount = account.getGoalAmount();

        //돈이 부족하다면.
        if(account.getBalance().compareTo(goalAmount) < 0){
            //enum으로 선언해준 104>>>>>>>>> E104("E104", "적금 계좌는 잔액이 목표 금액(%s원) 이상이어야 출금 가능합니다."),
            throw new WithdrawException(String.format(ErrorCode.E104.getErrMsg(), df.format(goalAmount)));
        }
    }
    @Override
    public savingAccount createAccount() throws InputMismatchException {
        try{
            // 계좌번호 채번
            // 계좌번호는 "0000"+증가한 seq 포맷을 가진 번호입니다.
            String accNo = String.format(new DecimalFormat("0000").format(++seq));
            String owner = askInput("\n소유주명을 입력해주세요.", "");
            BigDecimal amount = askInput("\n최초 입금액을 입력해주세요.", BigDecimal.ZERO);
            BigDecimal goalAmount = askInput("\n목표 금액을 입력해주세요.", BigDecimal.ZERO);
            savingAccount account = new savingAccount(accNo, owner, amount, goalAmount);
            CentralBank.getInstance().getAccountList().add(new savingAccount(accNo, owner, amount, goalAmount));
            System.out.printf("%s님 계좌가 발급되었습니다.", owner);
            return account;
        }catch (InputMismatchException ime){
            if(seq > 0) seq--;
            throw ime;
        }catch (Exception e){
            throw e;
        }
    }
}
