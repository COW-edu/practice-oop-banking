package Accountfile;

import java.math.BigDecimal;

public class SavingAccount extends Account{
    public final BigDecimal targetAmount;
    public SavingAccount(String accountNumber, String owner, BigDecimal balance, BigDecimal targetAmount){
        super(accountNumber,owner,balance);
        this.targetAmount = targetAmount;
        this.accountType = "S";
    }
    public String getAccountInfo(){
        return getAccountInfo() + "\n" + targetAmount;
    }
}