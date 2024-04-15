package account;
import interest.BasicAccountInterest;
import interest.InterestCalculator;
import interest.SavingAccountInterest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountType {
	SAVING_ACCOUNT("적금 계좌", new SavingAccountMaker(), new SavingAccountInterest()),
	BASIC_ACCOUNT("예금 계좌", new BasicAccountMaker(),new BasicAccountInterest());

	public static final int MIN_INDEX = 1;
	public static final int MAX_INDEX = AccountType.values().length;

	private final String accountName;
	private final AccountMaker accountMaker;
	private final InterestCalculator interestCalculator;
}
