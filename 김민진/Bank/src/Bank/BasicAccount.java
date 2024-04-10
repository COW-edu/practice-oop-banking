package Bank;

import java.util.Scanner;

public class BasicAccount {
    private Credit credit;
    private Debit debit;
    private Scanner scanner;

    public void basicAccount() {
        scanner = new Scanner(System.in);

        boolean exit = false;
        do {
            // 메뉴 출력
            System.out.println("------------------");
            System.out.println("1. Credit  2. Debit");
            System.out.println("3. Exit");
            System.out.println("------------------");
            System.out.print("Enter choice: ");

            // 사용자 입력 받기
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    performCredit();
                    break;
                case 2:
                    performDebit();
                    break;
                case 3:
                    exit = true; // 사용자가 종료를 선택하면 루프를 종료
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (!exit);
        System.out.println("Exiting...");
        scanner.close();
    }

    // 신용 거래 수행
    private void performCredit() {
        if (credit == null) {
            credit = new Credit();
        }
        credit.creditTransaction();
    }

    // 차변 거래 수행
    private void performDebit() {
        if (debit == null) {
            debit = new Debit();
        }
        debit.debitTransaction();
    }
}
