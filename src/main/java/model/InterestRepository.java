package model;

import account.AccountType;
import interest.InterestCalculator;

public interface InterestRepository {
  InterestCalculator getCalculator(AccountType accountType);
}
