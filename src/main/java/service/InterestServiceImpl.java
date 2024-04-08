package service;

import account.AccountType;
import interest.InterestCalculator;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.InterestRepository;
import model.InterestRepositoryImpl;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InterestServiceImpl implements InterestService {
  private final InterestRepository interestRepository = InterestRepositoryImpl.getInstance();

  @Getter
  private static final InterestService instance = new InterestServiceImpl();

  @Override
  public BigDecimal getInterest(AccountType accountType, BigDecimal balance) {
    InterestCalculator interestCalculator = interestRepository.getCalculator(accountType);
    return interestCalculator.getInterest(balance);
  }
}
