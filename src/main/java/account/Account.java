package account;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import global.AccountType;

public interface Account {
	final StringBuilder stringBuilder = new StringBuilder();
	final DecimalFormat decimalFormat = new DecimalFormat("###,###");
	String getAccountInfo();
	/**
	 * value만큼 잔액을 뺀 뒤에 성공 여부를 반환한다.
	 */
	boolean withdraw(BigDecimal value);
	/**
	 * value만큼 잔액을 더한다.
	 */
	void deposit(BigDecimal value);
	/**
	 * accountNumber와 계좌번호의 일치 여부를 반환한다.
	 */
	boolean checkNumber(String accountNumer);
	/**
	 * Account Type을 반환한다.
	 * @return AccountType
	 */
	AccountType getAccountType();
	BigDecimal getBalance();
	boolean isActive();
	void deactive();
	void active();
}
