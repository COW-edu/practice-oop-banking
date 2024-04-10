package Bank;

import java.util.Arrays;
import java.util.Scanner;

public class SAccount {
    private static Scanner scanner = new Scanner(System.in);
    private static Account[] accounts = new Account[100];

    // S 계좌 거래 수행 메서드
    public void sAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        // 계좌번호로 계좌 검색
        Account account = findAccountByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number. Please enter the correct account number.");
            return;
        }

        // 입금할 금액 입력
        System.out.print("Enter the amount to deposit: ");
        int amount = Integer.parseInt(scanner.nextLine());

        // 입금 처리
        account.deposit(amount);
        System.out.println("Transaction completed.");
    }

    // 계좌번호로 계좌 검색하는 메서드
    private Account findAccountByAccountNumber(String accountNumber) {
        return Arrays.stream(accounts)
                     .filter(account -> account != null && account.getAccountNumber().equals(accountNumber))
                     .findFirst()
                     .orElse(null);
    }

}
