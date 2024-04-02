package Bank;

import java.util.Scanner;

public class BankApplication {
    
    private CreateAccount createAccount;
    private AccountList accountList;
    private BasicAccount basicAccount;
    private NAccount nAccount;
    private SAccount sAccount;
    static Scanner scanner = new Scanner(System.in);

    public BankApplication() {
        boolean run = false;
        do {
            System.out.println("------------------------------------------------------");
            System.out.println("1.creation 2.list 3.basic 4.NAccount 5.SAccount 6.exit");
            System.out.println("------------------------------------------------------");
            System.out.print("number> ");
            
            int code = Integer.parseInt(scanner.nextLine());

            switch (code) {
                case 1:
                    createAccount = new CreateAccount();
                    createAccount.createAccount(); // CreateAccount 클래스의 createAccount 메서드 호출
                    break;
                case 2:
                    accountList = new AccountList();
                    accountList.accountList();
                    break;
                case 3:
                	basicAccount = new BasicAccount();
                	basicAccount.basicAccount();
                    break;
                case 4:
                	nAccount = new NAccount();
                	nAccount.nAccount();
                    break;
                case 5:
                	sAccount = new SAccount();
                	sAccount.sAccount();
                    break;
                case 6:
                    run = true;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            
        } while(!run);
        System.out.println("exit");
    }
}
