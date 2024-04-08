package service;

import account.AccountType;
import java.math.BigDecimal;

public interface InterestService {
  BigDecimal getInterest(AccountType accountType, BigDecimal balance);
}
