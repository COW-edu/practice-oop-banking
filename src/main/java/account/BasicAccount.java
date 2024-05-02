package account;
import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BasicAccount extends Account {
	private final AccountType accountType = AccountType.BASIC_ACCOUNT;
	private final String accountNumber;
	private String owner;
	private BigDecimal balance;
	private boolean activation;

	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public synchronized void deactivate() {
		this.activation = false;
	}

	@Override
	public boolean canWithdrawal(BigDecimal withdrawalAmount) {
		return (balance.compareTo(withdrawalAmount) >= 0);
	}

	@Override
	public synchronized void activate() {
		this.activation = true;
	}

	@Override
	public boolean isDeactivate() {
		return !this.activation;
	}

	@Override
	public synchronized void withdrawal(BigDecimal value) {
		this.balance = this.balance.subtract(value);
	}

	@Override
	public synchronized void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}

	public synchronized String getAccountInfo() {
		stringBuilder.setLength(0);
		stringBuilder.append("[계좌 정보]").append("\n");
		stringBuilder.append("계좌 종류: ").append(accountType.getAccountName()).append("\n");
		stringBuilder.append("계좌번호: ").append(getAccountNumber()).append("\n");
		stringBuilder.append("계좌주: ").append(getOwner()).append("\n");
		stringBuilder.append("잔액: ￦").append(decimalFormat.format(getBalance())).append("\n");
		stringBuilder.append("활성화 상태: ").append(isActivation());
		return stringBuilder.toString();
	}
}
