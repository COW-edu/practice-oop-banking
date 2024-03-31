package bank.clerk;

import account.Account;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankSystem;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateAccountClerk implements Clerk{

    private final BankSystem bankSystem;
    private final Scanner scanner = new Scanner(System.in);

    public CreateAccountClerk(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    public void action() {
        validateAccountType();
    }

    private void validateAccountType() {
        System.out.println("개설하실 계좌 유형과 이름을 작성해주세요 ex) 예금계좌, 적금계좌 / 홍길동");
        String accountType = getUserInput();

        switch (accountType) {
            case "예금계좌": createDepositAccount(); break;
            case "적금계좌": BigDecimal target = promptForTargetAmount(); createSavingAccount(target); break;
            default: System.out.println("지원하지 않는 계좌 유형입니다.");break;
        }
    }

    private void createDepositAccount() {
        String name = scanner.nextLine();
        Account account = new DepositAccount("N", "", name, BigDecimal.ZERO, true);
        String accountNumber = bankSystem.createAccount(account);
        System.out.println("예금 계좌가 생성되었습니다. 계좌번호는 [" + accountNumber + "] 입니다.");
    }

    private void createSavingAccount(BigDecimal target) {
        String name = scanner.nextLine();
        Account account = new SavingAccount("S", "", name, BigDecimal.ZERO, target, true);
        String accountNumber = bankSystem.createAccount(account);
        System.out.println("적금 계좌가 생성되었습니다. 계좌번호는 [" + accountNumber + "] 입니다.");
    }

    private BigDecimal promptForTargetAmount() {
        System.out.println("목표금액을 설정해주세요");
        return new BigDecimal(getUserInput());
    }

    public String getUserInput() {
        return scanner.nextLine().trim();
    }
}