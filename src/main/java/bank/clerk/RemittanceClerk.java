package bank.clerk;

import bank.BankSystem;

import java.math.BigDecimal;
import java.util.Scanner;

public class RemittanceClerk implements Clerk{

    BankSystem bankSystem;
    Scanner sc = new Scanner(System.in);

    public void action() {
        remittance();}

    public RemittanceClerk(BankSystem bankSystem){
        this.bankSystem = bankSystem;
    }

    public void remittance() {
        System.out.println("출금계좌, 입금계좌, 금액을 차례로 작성해주세요");
        String fromAccountNum = getUserInput();
        String toAccountNum = getUserInput();
        BigDecimal balance = new BigDecimal(getUserInput());

        String balanceResult = bankSystem.remittance(fromAccountNum, toAccountNum,  balance);

        resultMessage(balanceResult);
    }

    public String getUserInput() {
        return sc.nextLine().trim();
    }

    private void resultMessage(String balanceResult){
        System.out.println("송금완료! [잔고] = " + balanceResult);
    }

}
