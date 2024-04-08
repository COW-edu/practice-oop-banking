package bank;

import java.math.BigDecimal;

public class SavingInterestCalculator implements InterestCalculator{
    BigDecimal interest;

    public BigDecimal getInterest(BigDecimal balance){
        if (balance.compareTo(BigDecimal.valueOf(1000000)) >= 0)
            interest = BigDecimal.valueOf(0.5); // 50% 이자
         else
            interest = BigDecimal.valueOf(0.01); // 1% 이자
        return balance.multiply(interest);
    }
}
