package Bank;

import java.util.Scanner;

public class BankApplication {
    
    private CreateAccount createAccount;
    private AccountList accountList;
    private BasicAccount basicAccount;
    private NAccount nAccount;
    private SAccount sAccount;
    private static Scanner scanner = new Scanner(System.in);

    public BankApplication() {
        boolean run = false;
        do {
            displayMenu();
            int code = Integer.parseInt(scanner.nextLine());
            switch (code) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    listAccounts(); // 'List Accounts' 선택 시 AccountList 클래스와 연결
                    break;
                case 3:
                    operateBasicAccount();
                    break;
                case 4:
                    operateNAccount();
                    break;
                case 5:
                    operateSAccount();
                    break;
                case 6:
                    run = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (!run);
        System.out.println("Exiting...");
    }
    
    private void displayMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("1. Create Account  2. List Accounts  3. Basic Account");
        System.out.println("4. N Account       5. S Account     6. Exit");
        System.out.println("------------------------------------------------------");
        System.out.print("Enter your choice: ");
    }
    
    private void createAccount() {
        createAccount = new CreateAccount();
        createAccount.createAccount();
    }
    
    private void listAccounts() {
        accountList = new AccountList();
        accountList.accountList();
    }
    
    private void operateBasicAccount() {
        basicAccount = new BasicAccount();
        basicAccount.basicAccount();
    }
    
    private void operateNAccount() {
        nAccount = new NAccount();
        nAccount.nAccount();
    }
    
    private void operateSAccount() {
        sAccount = new SAccount();
        sAccount.sAccount();
    }
    
}
