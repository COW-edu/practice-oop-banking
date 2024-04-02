package Bank;

import java.util.Scanner;

public class BasicAccount {

	private Credit credit;
	private Devit devit;
	
	public void basicAccount() {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = false;
        do {
            System.out.println("----------------");
            System.out.println("1.credit 2.devit");
            System.out.println("----------------");
            System.out.print("number> ");
            int code = Integer.parseInt(scanner.nextLine());
            
            switch (code) {
            case 1:
                credit = new Credit();
                credit.credit(); // CreateAccount 클래스의 createAccount 메서드 호출
                break;
            case 2:
            	devit = new Devit();
            	devit.devit();
            default:
                System.out.println("error");
                break;
            }
            
        } while(!run);
    System.out.println("exit");
	}
}
        

