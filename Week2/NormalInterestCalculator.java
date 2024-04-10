package Week2;

import java.math.BigDecimal;

public class NormalInterestCalculator implements InterestCalculator{

    // 1000만원이상은 이자율 50%, 500만원 이상은 7%, 100만원 이상은 4%, 1만원 이상은 2%, 그 외에는 1%
    public BigDecimal getInterest(BigDecimal balance){ // 계좌 잔액에 대한 이자금액 반환

        if( balance.compareTo(BigDecimal.valueOf(1000)) >= 0 )
            return balance.multiply(BigDecimal.valueOf(0.5));
        else if ( balance.compareTo(BigDecimal.valueOf(500)) >= 0)
            return balance.multiply(BigDecimal.valueOf(0.07));
        else if ( balance.compareTo(BigDecimal.valueOf(100)) >= 0)
            return balance.multiply(BigDecimal.valueOf(0.04));
        else if( balance.compareTo(BigDecimal.ONE) >= 0)
            return balance.multiply(BigDecimal.valueOf(0.02));
        else
            return balance.multiply(BigDecimal.valueOf(0.01));

    }

}