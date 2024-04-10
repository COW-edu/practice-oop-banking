package Bank;

public class AccountList {
    private static final int MAX_ACCOUNTS = 100;
    private static Account[] accounts = new Account[MAX_ACCOUNTS];
    private static int index = 0;

    public static void accountList() {
        for (int i = 0; i < index; i++) {
            accounts[i].printAccountInfo();
        }
    }

    public static void addAccount(Account account) {
        if (index < MAX_ACCOUNTS) {
            accounts[index] = account;
            index++;
        } else {
            System.out.println("Cannot add more accounts. Account list is full.");
        }
    }
}
