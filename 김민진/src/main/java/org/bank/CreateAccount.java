package org.bank;

import static org.bank.BankApplication.accountArray;
import static org.bank.BankApplication.scanner;

public class CreateAccount {
    private static void createAccount() {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");
        System.out.print("계좌종류: ");
        String type = scanner.next();
        System.out.print("계좌번호: ");
        int AccountNumber = Integer.parseInt(scanner.next());

        System.out.print("계좌주: ");
        String name = scanner.next();

        System.out.print("잔액: ");
        int Balance = Integer.parseInt(scanner.next());

        System.out.print("활성화여부: ");
        String isActivated = scanner.next();

        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = new Account(type, AccountNumber, name, Balance, isActivated);
                System.out.println("결과: 계좌가 생성되었습니다.");
                break;
            }
        }
    }
}
