package account;

import Interest.DepositInterest;
import Interest.InterestCalculator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositAccount implements Account{

    InterestCalculator interestCalculator;
    String type;
    String accountNum;
    String name;
    BigDecimal balance;
    boolean status;

    public DepositAccount(DepositInterest depositInterest){
        this.interestCalculator = depositInterest;
    }
    public DepositAccount(String type, String accountNum, String name, BigDecimal balance, boolean status) {
        this.type = type;
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;
        this.status = status;
    }

    @Override
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    public String deposit(BigDecimal balance){
        BigDecimal interest = interestCalculator.getInterest(balance);
        setBalance(getBalance().add(balance.add(interest)));
        return "입금완료! [잔고] = " + getBalance();
    }
}
