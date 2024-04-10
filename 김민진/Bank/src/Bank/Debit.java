package Bank;

import java.util.Scanner;

public class Debit {
    private static final int MAX_ACCOUNTS = 100;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Account[] accounts = new Account[MAX_ACCOUNTS];
    private static int index = 0;

    // 차변 거래 수행 메서드
    public void debitTransaction() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        // 계좌번호로 계좌 검색
        Account account = findAccountByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number. Please enter the correct account number.");
            return;
        }

        // 출금할 금액 입력
        System.out.print("Enter the amount to withdraw: ");
        int amount = Integer.parseInt(scanner.nextLine());

        // 출금 처리
        account.withdraw(amount);
        System.out.println("Transaction completed.");
    }

    // 계좌번호로 계좌 검색하는 메서드
    private Account findAccountByAccountNumber(String accountNumber) {
        for (int i = 0; i < index; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}
