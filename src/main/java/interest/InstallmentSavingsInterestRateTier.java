package interest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum InstallmentSavingsInterestRateTier {

    TIER(new BigDecimal("1000000"), new BigDecimal("0.5"));

    private final BigDecimal balanceThreshold;
    private final BigDecimal interestRate;

    public static BigDecimal findInterestRateForBalance(BigDecimal balance) {
        return Arrays.stream(InstallmentSavingsInterestRateTier.values())
                .filter(tier -> balance.compareTo(tier.getBalanceThreshold()) >= 0)
                .map(InstallmentSavingsInterestRateTier::getInterestRate)
                .max(BigDecimal::compareTo)
                .orElse(new BigDecimal("0.01"));
    }
}