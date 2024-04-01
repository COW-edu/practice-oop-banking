package account;
import java.math.BigDecimal;

import global.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SavingAccount implements Account{
	private AccountType accountType;
	private String accountNumber;
	private String owner;
	private BigDecimal balance;
	private BigDecimal targetAmount;
	private boolean isActivated;
	public static Account getInstance(String accountNumber, String owner, BigDecimal balance, BigDecimal targetAmount, boolean isActivated) {
		return new SavingAccount(AccountType.NORMAL_ACCOUNT, accountNumber, owner, balance, targetAmount, isActivated);
	}
	@Override
	public synchronized boolean withdraw(BigDecimal value) {
		if(this.balance.compareTo(this.targetAmount) < 0) // 잔액보다 목표 금액이 큰 경우
			return false;
		if(this.balance.compareTo(value) < 0) // 잔액보다 출금 금액이 더 큰 경우
			return false;
		this.balance = this.balance.subtract(value);
		return true;
	}
	@Override
	public synchronized void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}
	@Override
	public synchronized String getAccountInfo() {
		stringBuilder.setLength(0);
		stringBuilder.append("[계좌 정보]").append("\n");
		stringBuilder.append("계좌종류: ").append(accountType.getAccountName()).append("\n");
		stringBuilder.append("계좌번호: ").append(getAccountNumber()).append("\n");
		stringBuilder.append("소유자: ").append(getOwner()).append("\n");
		stringBuilder.append("잔액: ￦ ").append(decimalFormat.format(getBalance())).append("\n");
		stringBuilder.append("목표 금액 : ￦ ").append(decimalFormat.format(getTargetAmount())).append("\n");
		stringBuilder.append("활성여부: ").append(isActivated());
		return stringBuilder.toString();
	}
	public boolean checkNumber(String accountNumber) {
		return this.accountNumber.equals(accountNumber);
	}
	@Override
	public AccountType getAccountType() {
		return this.accountType;
	}
	@Override
	public synchronized void deactive() {
		this.isActivated = false;
	}
	@Override
	public synchronized void active() {
		this.isActivated = true;
	}
	@Override
	public boolean isActive() {
		return this.isActivated;
	}
}
