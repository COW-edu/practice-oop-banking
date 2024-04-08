package exception;

import common.ErrorMessage;
import lombok.Getter;

@Getter
public class DeactivatedAccountException extends Exception {

	private final String accountNumber;
	public DeactivatedAccountException(ErrorMessage errorMessage, String accountNumber) {
		super(errorMessage.getPrintMessage());
		this.accountNumber = accountNumber;
	}
}
