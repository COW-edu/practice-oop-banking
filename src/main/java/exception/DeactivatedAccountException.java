package exception;

import account.Account;

public class DeactivatedAccountException extends Exception {
	private static final long serialVersionUID = 1L;

	private Account account;
	public DeactivatedAccountException(Account account) {
		super();
		this.account = account;
	}
	public DeactivatedAccountException(String msg, Account account) {
		super(msg);
		this.account = account;
	}
	public Account getAccount() {
		return this.account;
	}
}
