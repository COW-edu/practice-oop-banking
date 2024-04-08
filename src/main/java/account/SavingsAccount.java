package account;

import interest.InterestCalculator;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    public SavingsAccount(InterestCalculator interestCalculator, String type, String accountNum, String name, BigDecimal balance, BigDecimal target, boolean status) {
        super(interestCalculator, type, accountNum, name, balance, target, status);
    }
}


