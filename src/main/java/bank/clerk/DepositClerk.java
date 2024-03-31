package bank.clerk;

import bank.BankSystem;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositClerk implements Clerk{

    private final BankSystem bankSystem;
    private final Scanner sc = new Scanner(System.in);

    public DepositClerk(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    public void action() {
        deposit();
    }

    public void deposit() {
        System.out.println("[송금] 계좌, 금액을 작성해주세요");

        String accountNum = getUserInput();
        BigDecimal balance = new BigDecimal(getUserInput());

        String balanceResult = bankSystem.deposit(accountNum, balance);

        resultMessage(balanceResult);
    }
    public String getUserInput() {
        return sc.nextLine().trim();
    }

    private void resultMessage(String balanceResult){
        System.out.println(balanceResult);
    }
}
