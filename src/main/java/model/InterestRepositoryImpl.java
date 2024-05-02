package model;

import account.AccountType;
import interest.InterestCalculator;
import java.util.HashMap;
import lombok.Getter;

public class InterestRepositoryImpl implements InterestRepository {
  private final HashMap<AccountType, InterestCalculator> interestPolicies = new HashMap<>();

  @Getter
  private static final InterestRepository instance = new InterestRepositoryImpl();

  private InterestRepositoryImpl() {
    for (AccountType accountType : AccountType.values()){
      interestPolicies.put(accountType, accountType.getInterestCalculator());
    }
  }

  @Override
  public InterestCalculator getCalculator(AccountType accountType) {
    return interestPolicies.get(accountType);
  }
}
