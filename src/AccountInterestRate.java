import java.math.BigDecimal;

public class AccountInterestRate implements InterestCalculator
{
    @Override
    public BigDecimal getInterest(BigDecimal amount)
    {
        BigDecimal overTenM= new BigDecimal("10000000"); // 천만
        BigDecimal overFiveM = new BigDecimal("5000000"); // 오백만
        BigDecimal overM = new BigDecimal("1000000"); // 백만
        BigDecimal overTenT = new BigDecimal("10000"); // 만

        if(amount.compareTo(overTenM) >= 0) { return new BigDecimal("0.5");} // 이자율 50%
        else if(amount.compareTo(overFiveM) >= 0) { return new BigDecimal("0.07");} // 이자율 7%
        else if(amount.compareTo(overM) >= 0) { return new BigDecimal("0.04");} // 이자율 4%
        else if(amount.compareTo(overTenT) >= 0) { return new BigDecimal("0.02");} // 이자율 2%
        else { return new BigDecimal("0.01");} // 이자율 1%
    }
}
