package exception;

import account.Account;
import common.ErrorMessage;
import java.io.Serial;
import lombok.Getter;

@Getter
public class DeactivatedAccountException extends Exception {

	private final String accountNumber;
	public DeactivatedAccountException(ErrorMessage errorMessage, String accountNumber) {
		super(errorMessage.getPrintMessage());
		this.accountNumber = accountNumber;
	}
}
