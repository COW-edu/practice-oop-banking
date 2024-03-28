package banking.account.domain;

import java.math.BigDecimal;

public interface Account {
	String getAccountInfo();
	void withdraw(BigDecimal value);
	void deposit(BigDecimal value);
}
