package exception;

import common.Message;
import lombok.Getter;

@Getter
public class DeactivatedAccountException extends Exception {

	private final String accountNumber;
	public DeactivatedAccountException(Message errorMessage, String accountNumber) {
		super(errorMessage.getPrintMessage());
		this.accountNumber = accountNumber;
	}
}
