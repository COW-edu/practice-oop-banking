import java.math.BigDecimal;

public class SavingAccountInterestRate implements InterestCalculator
{
    @Override
    public BigDecimal getInterest(BigDecimal amount)
    {
        BigDecimal overM = new BigDecimal("1000000"); // 백만

        if(amount.compareTo(overM) >= 0) { return new BigDecimal("0.5");} // 이자율 50%
        else { return new BigDecimal("0.01");} // 이자율 1%
    }
}
