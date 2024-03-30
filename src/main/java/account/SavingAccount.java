package account;

import Interest.DepositInterest;
import Interest.InterestCalculator;
import Interest.SavingInterest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class SavingAccount implements Account{

    InterestCalculator interestCalculator;
    String type;
    String accountNum;
    String name;
    BigDecimal balance;
    BigDecimal target;
    boolean status;


    public SavingAccount(SavingInterest savingInterest){
        this.interestCalculator = savingInterest;
    }

    public SavingAccount(String type, String accountNum, String name, BigDecimal balance, BigDecimal target, boolean status) {
        this.type = type;
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;
        this.target = target;
        this.status = status;
    }

    @Override
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String deposit(BigDecimal balance) {

    return "";
    }
}
