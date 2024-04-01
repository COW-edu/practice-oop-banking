package BankingSystem.bank;

import java.math.BigDecimal;

public interface InterestCalculator {


    /** 계좌종류와 이자율에 따라 계산된 지급이자를 반환
     *
     * @param balance
     * @return interest 더해질 이자금액
     */
    BigDecimal getInterest(BigDecimal balance);

}
