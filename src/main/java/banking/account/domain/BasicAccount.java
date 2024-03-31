package banking.account.domain;

import java.math.BigDecimal;

import banking.account.constant.AccountName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class BasicAccount {

	private AccountName accountType;
	private String accountNumber;
	private String owner;
	private BigDecimal balance;
	private boolean isActivated;

	public String getAccountInfo() {
		return "계좌정보 = [" +
				" 계좌타입=" + accountType +
				", 계좌번호='" + accountNumber + '\'' +
				", 소유주='" + owner + '\'' +
				", 잔액=" + balance +
				", 활성화 여부=" + isActivated +
				']' + " \n" ;
	}
}
