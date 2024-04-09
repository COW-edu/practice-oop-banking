package Week2;

// TODO: 구현

import lombok.Getter;


import java.math.BigDecimal;

@Getter
public class SavingAccount extends BasicAccount{
    private BigDecimal targetAmount;

    public SavingAccount(AccountType accountType, String accountNumber, String owner, BigDecimal balance, boolean isActivated,BigDecimal targetAmount ) {
        super( accountType, accountNumber, owner, balance, isActivated);
        this.targetAmount = targetAmount;
    }

    @Override
    public String getAccountInfo() {
        return super.getAccountInfo() + "\n목표 금액: " + targetAmount + "\n" ;
    }

//    public BigDecimal getTargetAmount() {
//        return targetAmount;
//    }
//    public void setBalance(BigDecimal balance) {  super.setBalance(balance);}

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void withdraw(BigDecimal value) {
        BigDecimal target = getTargetAmount();
        int temp = getBalance().compareTo(target.multiply(BigDecimal.valueOf(0.01)));
        if(temp > 0) {
            setBalance(getBalance().subtract((value)));
        }
    }


}