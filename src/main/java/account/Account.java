package account;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Account {
	protected final StringBuilder stringBuilder = new StringBuilder();
	protected final DecimalFormat decimalFormat = new DecimalFormat("###,###");

	public static Account empty(){
		return new Account() {
			public boolean isEmpty() { return true; }
			public String getAccountInfo() { return null; }
			public void withdrawal(BigDecimal value) {}
			public void deposit(BigDecimal value) {}
			public AccountType getAccountType() { return null; }
			public BigDecimal getBalance() { return null; }
			public String getAccountNumber() { return null; }
			public boolean isDeactivate() { return false; }
			public boolean canWithdrawal(BigDecimal withdrawalAmount) { return false; }
			public void activate() {}
			public void deactivate() {}
		};
	}

	public boolean isEmpty() {
		return false;
	}
  public abstract String getAccountInfo();
	public abstract void withdrawal(BigDecimal value);
	public abstract void deposit(BigDecimal value);
	public abstract AccountType getAccountType();
	public abstract BigDecimal getBalance();
	public abstract String getAccountNumber();
	public abstract boolean isDeactivate();
	public abstract boolean canWithdrawal(BigDecimal withdrawalAmount);
	public abstract void activate();
	public abstract void deactivate();
}
