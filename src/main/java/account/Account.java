package account;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Account {
	protected final StringBuilder stringBuilder = new StringBuilder();
	protected final DecimalFormat decimalFormat = new DecimalFormat("###,###");

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
