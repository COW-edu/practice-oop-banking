package interest;

import accounts.Account;

import java.math.BigDecimal;

public abstract class InterestCalculator {

    protected static final BigDecimal TEN_MILLION = new BigDecimal("10000000"); // 천만
    protected static final BigDecimal FIVE_MILLION = new BigDecimal("5000000"); // 오백만
    protected static final BigDecimal ONE_MILLION = new BigDecimal("1000000"); // 백만
    protected static final BigDecimal TEN_THOUSAND = new BigDecimal("10000"); // 만

    protected static final BigDecimal RATE_50 = new BigDecimal("0.5"); // 이자율 50%
    protected static final BigDecimal RATE_7 = new BigDecimal("0.07"); // 이자율 7%
    protected static final BigDecimal RATE_4 = new BigDecimal("0.04"); // 이자율 4%
    protected static final BigDecimal RATE_2 = new BigDecimal("0.02"); // 이자율 2%
    protected static final BigDecimal RATE_1 = new BigDecimal("0.01"); // 이자율 1%
    public abstract BigDecimal calculateInterest(BigDecimal amoount);
}

