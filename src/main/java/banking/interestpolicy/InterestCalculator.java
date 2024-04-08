package banking.interestpolicy;

import java.math.BigDecimal;

public interface InterestCalculator {

  //계좌 잔액에 대한 이자금액을 반환하는 메서드
  BigDecimal getInterest(BigDecimal balance);
}
