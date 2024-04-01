package banking;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import account.Account;
import account.BasicAccount;
import account.SavingAccount;
import exception.DeactivatedAccountException;
import global.AccountType;
import interest.InterestCalculator;

public class CentralBank {
	private static CentralBank centralBank;
	private static ArrayList<Account> accountList;
	private static HashMap<AccountType, InterestCalculator> interestPolicy;
	private CentralBank() {
		accountList = new ArrayList<Account>();
		interestPolicy = new HashMap<AccountType, InterestCalculator>();
		for(AccountType accountType : AccountType.values()) {
			interestPolicy.put(accountType, accountType.getInterestCalculator());
		}
	}
	public static CentralBank getInstance() {
		centralBank = Optional.ofNullable(centralBank).orElseGet(CentralBank::new);
		return centralBank;
	}
	private String makeAccountNumber() {
		String accountNumber;
		while(true) {
			accountNumber = "" + ((int)(Math.random() * 899999999) + 100000000); // 100000000~999999999 랜덤 숫자
			if(!checkAccountNumber(accountNumber))
				return accountNumber;
		}
	}
	/**
	 * 계좌 생성에 성공하면 계좌 번호를 반환한다.
	 * @param accountType 계좌의 종류를 전달받는다.
	 * @param owner 게좌주의 이름을 전달받는다.
	 * @return 만들어진 계좌의 계좌번호
	 */
	public String makeAccount(AccountType accountType, String owner) {
		if(!accountType.equals(AccountType.NORMAL_ACCOUNT)) return null;
		String accountNumber = makeAccountNumber();
		Account account = BasicAccount.getInstance(accountNumber, owner, new BigDecimal(0), true);
		if(accountList.add(account))
			return accountNumber;
		else
			return null;
	}
	/**
	 * 계좌 생성에 성공하면 계좌 번호를 반환한다.
	 * @param accountType 계좌의 종류
	 * @param owner 게좌주의 이름
	 * @param targetAmount 목표 금액
	 * @return 만들어진 계좌의 계좌번호
	 */
	public String makeAccount(AccountType accountType, String owner, BigDecimal targetAmount) {
		if(!accountType.equals(AccountType.SAVING_ACCOUNT)) return null;
		String accountNumber = makeAccountNumber();
		Account account = SavingAccount.getInstance(accountNumber, owner, new BigDecimal(0), targetAmount, true);
		if(accountList.add(account))
			return accountNumber;
		else
			return null;
	}
	public boolean checkAccountNumber(String accountNumber) {
		for(Account account : accountList) {
			if(account.checkNumber(accountNumber))
				return true;
		}
		return false;
	}
	private Account getAccount(String accountNumber) throws DeactivatedAccountException {
		Account account = null;
		for(Account ac : accountList) {
			if(ac.checkNumber(accountNumber)) {
				account = ac;
				break;
			}
		}
		if(account == null) return null;
		if(!account.isActive()) throw new DeactivatedAccountException(account);
		return account;
	}
	public boolean withdrawal(String accountNumber, BigDecimal withdrawalAmount) {
		for(Account account : accountList) {
			if(account.checkNumber(accountNumber))
				return account.withdraw(withdrawalAmount);
		}
		return false;
	}
	public void deposit(String accountNumber, BigDecimal depositAmount) {
		accountList.stream()
			.filter((account) -> account.checkNumber(accountNumber))
			.forEach((account) -> account.deposit(depositAmount));
	}
	
	public String getAccountInfo(String accountNumber) throws DeactivatedAccountException {
		Account account = this.getAccount(accountNumber);
		return account != null ? account.getAccountInfo() : "";
	}
	public boolean deleteAccount(String accountNumber) {
		Account account = null;
		try {
			account = this.getAccount(accountNumber);
		} catch (DeactivatedAccountException e) {
			return accountList.remove(e.getAccount());
		}
		return account != null ? accountList.remove(account) : false;
	}
	public String getInterest(String accountNumber) throws DeactivatedAccountException {
		Account account = this.getAccount(accountNumber);
		String result = "";
		if(account != null) {
			result = interestPolicy.get(account.getAccountType())
				.getInterest(account.getBalance())
				.toString();
		}
		return result;
	}
	public void deactive(String accountNumber) throws DeactivatedAccountException {
		Account account = this.getAccount(accountNumber);
		account.deactive();
	}
	public void active(String accountNumber) {
		Account account = null;
		try {
			account = this.getAccount(accountNumber);
		} catch (DeactivatedAccountException e) {
			e.getAccount().active();
			return;
		}
		account.active();
	}
}
