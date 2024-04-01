package interest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum DepositInterestRateTier {
	TIER_1(new BigDecimal("10000"), new BigDecimal("0.02")),
	TIER_2(new BigDecimal("1000000"), new BigDecimal("0.04")),
	TIER_3(new BigDecimal("5000000"), new BigDecimal("0.07")),
	TIER_4(new BigDecimal("10000000"), new BigDecimal("0.50"));

	private final BigDecimal balanceThreshold;
	private final BigDecimal interestRate;

	public static BigDecimal findInterestRateForBalance(BigDecimal balance) {
		return Arrays.stream(DepositInterestRateTier.values())
				.filter(tier -> balance.compareTo(tier.getBalanceThreshold()) >= 0)
				.map(DepositInterestRateTier::getInterestRate)
				.max(BigDecimal::compareTo)
				.orElse(new BigDecimal("0.01"));
	}
}