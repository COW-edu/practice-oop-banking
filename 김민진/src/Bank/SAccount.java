package Bank;

import java.util.Scanner;

public class SAccount {
	
	static Scanner scanner = new Scanner(System.in);
	static Account[] accounts = new Account[100];
	static int index = 0;

	public void sAccount() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("accountNum: ");
		String accountNumber = scanner.nextLine();
		
		Account account = findAccountByAccountNumber(accountNumber);
		if(account == null) {
			System.out.println("계좌번호를 정확히 입력해주세요.");
			return;
		}
		System.out.print("money: ");
		int amout = Integer.parseInt(scanner.nextLine());
		
		account.deposit(amout);
		System.out.println("finish");
		
	}

private Account findAccountByAccountNumber(String accountNumber) {
	for(int i = 0; i < index; i++) {
		if(accounts[i].getAccountNumber().equals(accountNumber)) {
			return accounts[i];
		}
	}
	return null;
}
	

}
