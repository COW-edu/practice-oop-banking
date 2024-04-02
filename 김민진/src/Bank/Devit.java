package Bank;

import java.util.Scanner;

public class Devit {
	
	static Scanner scanner = new Scanner(System.in);
	static Account[] accounts = new Account[100];
	static int index = 0;

	public void devit() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("accountNum: ");
		String accountNumber = scanner.nextLine();
		
		Account account = findAccountByAccountNumber(accountNumber);
		if(account == null) {
			System.out.println("계좌번호를 정확히 입력해주세요.");
			return;
		}
		System.out.println("money: ");
		int amount = Integer.parseInt(scanner.nextLine());
		
		account.withdraw(amount);
		System.out.println("finish");
	}

	private Account findAccountByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
