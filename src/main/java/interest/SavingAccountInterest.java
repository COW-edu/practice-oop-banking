package interest;
import java.math.BigDecimal;

public class SavingAccountInterest implements InterestCalculator {
	@Override
	public BigDecimal getInterest(BigDecimal balance) {
		BigDecimal interest;
		if (balance.compareTo(SavingAccountInterestRange.INTEREST_RANGE_1.getValue()) >= 0) {
			interest = balance.multiply(SavingAccountInterestRange.INTEREST_PERCENT_1.getValue());
		} else {
			interest = balance.multiply(SavingAccountInterestRange.INTEREST_PERCENT_2.getValue());
		}
		return interest;
	}
}
