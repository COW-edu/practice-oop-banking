package interest;
import java.math.BigDecimal;

public class BasicAccountInterest implements InterestCalculator{
	@Override
	public BigDecimal getInterest(BigDecimal balance) {
		BigDecimal interest = null;
		if(balance.compareTo(getValueOf(10000000)) >= 0) {
			interest = balance.multiply(getValueOf(50)).divide(getValueOf(100));
		} else if (balance.compareTo(getValueOf(5000000)) >= 0) {
			interest = balance.multiply(getValueOf(7)).divide(getValueOf(100));
		} else if (balance.compareTo(getValueOf(1000000)) >= 0) {
			interest = balance.multiply(getValueOf(4)).divide(getValueOf(100));
		} else if (balance.compareTo(getValueOf(10000)) >= 0) {
			interest = balance.multiply(getValueOf(2)).divide(getValueOf(100));
		} else {
			interest = balance.multiply(getValueOf(1)).divide(getValueOf(100));
		}
		return interest;
	}
	private BigDecimal getValueOf(double i) {
		return BigDecimal.valueOf(i);
	}
}
