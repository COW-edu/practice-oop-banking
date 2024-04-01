package interest;
import java.math.BigDecimal;

public class SavingAccountInterest implements InterestCalculator{
	@Override
	public BigDecimal getInterest(BigDecimal balance) {
		BigDecimal interest = null;
		if(balance.compareTo(getValueOf(1000000)) >= 0) {
			interest = balance.multiply(getValueOf(5)).divide(getValueOf(100));
		} else {
			interest = balance.multiply(getValueOf(1)).divide(getValueOf(100));
		}
		return interest;
	}
	private BigDecimal getValueOf(double i) {
		return BigDecimal.valueOf(i);
	}
}
