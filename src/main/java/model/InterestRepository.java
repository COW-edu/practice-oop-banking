package model;

import account.AccountType;
import interest.InterestCalculator;
import java.math.BigDecimal;

public interface InterestRepository {
  public InterestCalculator getCalculator(AccountType accountType);
}
