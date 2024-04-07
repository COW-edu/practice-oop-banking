package org.bank;

import java.util.Scanner;
public class BankApplication {
    private AccountList accountList;
    private BasicAccount basicAccount;
    private NAccount nAccount;
    private SAccount sAccount;
    static Account[] accountArray = new Account[100];
    static Scanner scanner = new Scanner(System.in);

    public BankApplication() {
        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌생성 2.계좌목록 3.입출금 4.예금 5.적금 6.종료 ");
            System.out.println("---------------------------------------------");
            System.out.println("선택> ");

            String sCode = scanner.next();
            int iCode = Integer.parseInt(sCode);

            switch (iCode) {
                case 1:
                    CreateAccount createAccount = new CreateAccount();
                    break;
                case 2:
                    this.accountList = new AccountList();
                    break;
                case 3:
                    this.basicAccount = new BasicAccount();
                    break;
                case 4:
                    this.nAccount = new NAccount();
                    break;
                case 5:
                    this.sAccount = new SAccount();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
