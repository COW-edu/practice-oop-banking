package banking.account.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingAccount extends BasicAccount {

	private String targetAmount;

	@Override
	public StringBuilder getAccountInfo() {
		StringBuilder stringBuilder;
		stringBuilder = super.getAccountInfo();
		stringBuilder.append("목표 금액: ").append(getTargetAmount());
		return stringBuilder;
	}
}
