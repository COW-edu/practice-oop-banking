package Week2;

// TODO: 구현
import lombok.*;
import java.math.BigDecimal;

public class SavingAccount extends BasicAccount{
    private String targetAmount;

    public SavingAccount(AccountType accountType, String accountNumber, String owner, BigDecimal balance, boolean isActivated,String targetAmount ) {
        super( accountType, accountNumber, owner, balance, isActivated);
        this.targetAmount = targetAmount;
    }

//    public String getAccountNumber() { return accountNumber;}
    @Override
    public String getAccountInfo() {
        return super.getAccountInfo() + "\n목표 금액: " + targetAmount + "\n" ;
    }

    public String getTargetAmount() {
        return targetAmount;
    }
    public void setBalance(BigDecimal balance) {  super.setBalance(balance);}

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void withdraw(BigDecimal value) {
        BigDecimal target = new BigDecimal(getTargetAmount());
        int temp = getBalance().compareTo(target.multiply(BigDecimal.valueOf(0.01)));
        if(temp>0) {
            setBalance(getBalance().subtract((value)));
//        this.balance=this.balance.subtract(value);
//        System.out.println("withdraw"+getBalance());
        }
    }


}