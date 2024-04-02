package Bank;

public class AccountList {
	
	static Account[] accounts = new Account[100];
	static int index = 0;
	
	static void accountList() {
		for (int i = 0; i < index; i++) {
			accounts[i].printAccounts();
		}
	}
	

}
