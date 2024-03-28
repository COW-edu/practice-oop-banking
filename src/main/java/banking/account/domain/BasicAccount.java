package banking.account.domain;

import static banking.account.domain.AccountType.*;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BasicAccount implements Account {

	private final StringBuilder stringBuilder;

	private AccountType accountType;

	private String accountNumber;

	private String owner;

	// https://jsonobject.tistory.com/466
	private BigDecimal balance;

	private boolean isActivated;

	public String getAccountInfo() {
		stringBuilder.append("[계좌 정보]").append("\n");
		stringBuilder.append("계좌종류: ").append(accountType.getAccountName()).append("\n");
		stringBuilder.append("계좌번호: ").append(getAccountNumber()).append("\n");
		stringBuilder.append("소유자: ").append(getOwner()).append("\n");
		stringBuilder.append("잔액: ").append(getBalance()).append("\n");
		stringBuilder.append("활성여부: ").append(isActivated());
		return stringBuilder.toString();
	}

	public void withdraw(BigDecimal value) {
		this.balance.subtract(value);
	}

	public void deposit(BigDecimal value) {
		this.balance.add(value);
	}
}
