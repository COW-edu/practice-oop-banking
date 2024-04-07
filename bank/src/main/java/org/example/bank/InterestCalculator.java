package org.example.bank;
import java.math.BigDecimal;

public interface InterestCalculator {
    // 잔액에 대한 이자 금액을 반환하는 메서드 ( BigDecimal getInterest(balance)를 선언합니다.

    //getInterest method 구현 강제화
    BigDecimal getInterest(BigDecimal balance);

}