package banking.account.domain;

import java.math.BigDecimal;

public interface Account {
	StringBuilder getAccountInfo();
	BigDecimal withdraw(BigDecimal value);
	BigDecimal deposit(BigDecimal value);
}
