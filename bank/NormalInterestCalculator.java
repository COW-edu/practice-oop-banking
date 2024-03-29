package bank;

import java.math.BigDecimal;

public class NormalInterestCalculator implements InterestCalculator{

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        if(balance.compareTo(new BigDecimal(10000000))>=0)
            return balance.multiply(new BigDecimal(1.5));
        if(balance.compareTo(new BigDecimal(5000000))>=0)
            return balance.multiply(new BigDecimal(1.07));
        if(balance.compareTo(new BigDecimal(1000000))>=0)
            return balance.multiply(new BigDecimal(1.02));
        return balance.multiply(new BigDecimal(1.01));

        //테이블만들면 반복문으로 해결가능할듯.

    }

}
