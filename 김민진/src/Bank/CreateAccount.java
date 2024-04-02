package Bank;

import java.util.Scanner;

public class CreateAccount {
	
	static Account[] accounts = new Account[100];
	static int index = 0;
    static Scanner scanner = new Scanner(System.in);
	
    static void createAccount() {
    	System.out.print("type: ");
    	String type = scanner.nextLine();
    	
    	System.out.print("accountNum: ");
    	String accountNumber = scanner.nextLine();
    	
    	System.out.print("name: ");
    	String name = scanner.nextLine();
    	
    	System.out.print("balance: ");
    	int balance = Integer.parseInt(scanner.nextLine());
    	
    	System.out.print("isActivated: ");
    	String isActivated = scanner.nextLine();
    	
    	Account account = new Account();
    	accounts[index++] = account;
    }
}