package interest;
import java.math.BigDecimal;

public class BasicAccountInterest implements InterestCalculator {
  @Override
	public BigDecimal getInterest(BigDecimal balance) {
		BigDecimal interest;
		if (balance.compareTo(BasicAccountInterestRange.INTEREST_RANGE_1.getValue()) >= 0) {
			interest = balance.multiply(BasicAccountInterestRange.INTEREST_PERCENT_1.getValue());
		} else if (balance.compareTo(BasicAccountInterestRange.INTEREST_RANGE_2.getValue()) >= 0) {
			interest = balance.multiply(BasicAccountInterestRange.INTEREST_PERCENT_2.getValue());
		} else if (balance.compareTo(BasicAccountInterestRange.INTEREST_RANGE_3.getValue()) >= 0) {
			interest = balance.multiply(BasicAccountInterestRange.INTEREST_PERCENT_3.getValue());
		} else if (balance.compareTo(BasicAccountInterestRange.INTEREST_RANGE_4.getValue()) >= 0) {
			interest = balance.multiply(BasicAccountInterestRange.INTEREST_PERCENT_4.getValue());
		} else {
			interest = balance.multiply(BasicAccountInterestRange.INTEREST_PERCENT_5.getValue());
		}
		return interest;
	}
}
