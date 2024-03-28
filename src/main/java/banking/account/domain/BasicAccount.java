package banking.account.domain;

import static banking.account.domain.AccountType.*;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicAccount implements Account {

	private AccountType accountType;

	private String accountNumber;

	private String owner;

	// https://jsonobject.tistory.com/466
	private BigDecimal balance;

	private boolean isActivated;

	public StringBuilder getAccountInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[계좌 정보]").append("\n");
		stringBuilder.append("계좌종류: ").append(getAccountTypeMean(accountType)).append("\n");
		stringBuilder.append("계좌번호: ").append(getAccountNumber()).append("\n");
		stringBuilder.append("소유자: ").append(getOwner()).append("\n");
		stringBuilder.append("잔액: ").append(getBalance()).append("\n");
		stringBuilder.append("활성여부: ").append(isActivated());
		return stringBuilder;
	}

	public BigDecimal withdraw(BigDecimal value) {
		return this.balance.subtract(value);
	}

	public BigDecimal deposit(BigDecimal value) {
		return this.balance.add(value);
	}

	private String getAccountTypeMean(AccountType accountType) {
		if (accountType.equals(N)) {
			return "예금 계좌";
		}
		return "적금 계좌";
	}
}
