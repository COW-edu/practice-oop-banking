package Bank;

public class Account {
    private String type;
    private String accountNumber;
    private String name;
    private int balance;
    private String isActivated;
	private int amout;
    
    public Account() {
    	
    }

    public Account(String type, String accountNumber, String name, int balance, String isActivated) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.isActivated = isActivated;
    }
    
    public void printAccounts() {
		System.out.printf("accountNum : %s,name : %s, balance : %,dwon%n", accountNumber, name, balance);
	}

	public Object getAccountNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deposit(int amout) {
		this.balance += amout;
	}

	public void withdraw(int amount) {
		this.balance -= amout;
		
	}

}
