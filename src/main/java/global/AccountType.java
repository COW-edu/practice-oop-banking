package global;
import interest.BasicAccountInterest;
import interest.InterestCalculator;
import interest.SavingAccountInterest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountType {
	NORMAL_ACCOUNT("¿¹±Ý °èÁÂ", new BasicAccountInterest()),
	SAVING_ACCOUNT("Àû±Ý °èÁÂ", new SavingAccountInterest());

	private final String accountName;
	private final InterestCalculator interestCalculator;
}
