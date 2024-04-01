package interest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum SavingInterestRateTier {
	TIER(new BigDecimal("1000000"), new BigDecimal("0.5"));

	private final BigDecimal balanceThreshold;
	private final BigDecimal interestRate;

	public static BigDecimal findInterestRateForBalance(BigDecimal balance) {
		return Arrays.stream(SavingInterestRateTier.values())
				.filter(tier -> balance.compareTo(tier.getBalanceThreshold()) >= 0)
				.map(SavingInterestRateTier::getInterestRate)
				.max(BigDecimal::compareTo)
				.orElse(new BigDecimal("0.01"));
	}
}