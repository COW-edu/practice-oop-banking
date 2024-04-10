package Week2.InterestCalculator;

import Week2.InterestCalculator.InterestCalculator;

import java.math.BigDecimal;

public class SavingInterestCalculator implements InterestCalculator {

    // 100만원 이상은 이자율 50%, 그외에는 1%
    public BigDecimal getInterest(BigDecimal balance){ // 계좌 잔액에 대한 이자금액 반환

        if ( balance.compareTo(BigDecimal.valueOf(100)) >= 0)
            return balance.multiply(BigDecimal.valueOf(0.5));
        else
            return balance.multiply(BigDecimal.valueOf(0.01));
    }

}