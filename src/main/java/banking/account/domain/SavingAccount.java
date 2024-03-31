package banking.account.domain;

import banking.account.constant.AccountName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SavingAccount extends BasicAccount {

	private BigDecimal targetAmount;


	public SavingAccount(AccountName AccountType, String accountNumber, String owner, BigDecimal balance, boolean isActivated, BigDecimal targetAmount) {
		super(AccountType, accountNumber, owner, balance, isActivated);
		this.targetAmount = targetAmount;
	}

	public String getAccountInfo() {
		return "Account = [" +
				"계좌타입=" + super.getAccountType() +
				", 계좌번호='" + super .getAccountNumber()+ '\'' +
				", 소유주='" + super .getOwner()+ '\'' +
				", 잔액=" + super.getBalance()+
				", 활성화 여부=" + super.isActivated() +
				", 목표 금액=" + this.targetAmount +
				']' + " \n";
	}
}
