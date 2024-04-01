package BankingSystem.bank;

import java.math.BigDecimal;

public class SaveInterestCalculator implements InterestCalculator{

    @Override
    public BigDecimal getInterest(BigDecimal balance) {
        if(balance.compareTo(new BigDecimal(1000000))>=0)
            return balance.multiply(new BigDecimal(0.5));
        return balance.multiply(new BigDecimal(0.01));

        //테이블만들면 반복문으로 해결가능할듯.

    }

}