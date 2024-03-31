package bank.clerk;

import bank.BankSystem;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawClerk implements Clerk{

    BankSystem bankSystem;
    Scanner sc = new Scanner(System.in);

    public void action() {
        withdraw();}

    public WithdrawClerk(BankSystem bankSystem){
        this.bankSystem = bankSystem;
    }


    public void withdraw() {
        System.out.println("[출금] 계좌, 금액을 작성해주세요");

        String accountNum = getUserInput();
        BigDecimal balance = new BigDecimal(getUserInput());

        String balanceResult = bankSystem.withdraw(accountNum, balance);

        resultMessage(balanceResult);
    }

    public String getUserInput() {
        return sc.nextLine().trim();
    }

    private void resultMessage(String balanceResult){
        System.out.println("출금완료! [잔고] = " + balanceResult);
    }
}