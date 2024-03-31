package bank.clerk;

import bank.BankSystem;

import java.util.Scanner;

public class ChangeStatusClerk implements Clerk{

    private final BankSystem bankSystem;
    private final Scanner sc = new Scanner(System.in);

    public ChangeStatusClerk(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    public void action() {
        suspension();
    }

    public void suspension() {
        System.out.println("계좌상태를 변경하려면 계좌번호를 입력해주세요");

        String accountNum = getUserInput();
        String statusResult = bankSystem.changeStatus(accountNum);

        resultMessage(statusResult);
    }
    public String getUserInput() {
        return sc.nextLine().trim();
    }

    private void resultMessage(String balanceResult){
        System.out.println("계좌상태["+balanceResult+"]");
    }
}
