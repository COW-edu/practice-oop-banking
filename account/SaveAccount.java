package account;

import java.math.BigDecimal;

public class SaveAccount extends Account{

    private BigDecimal targetAmount;

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public SaveAccount(){
        super();
        this.eAccount = EAccount.S;
    }
    public SaveAccount(String accountHolder, String accountNum, BigDecimal targetAmount){
        this.accountHolder = accountHolder;
        this.accountNum = accountNum;
        this.targetAmount = targetAmount;
    }

    @Override
    public String getAccountInfo() {
        return super.getAccountInfo()+"\n 목표금액 : " + targetAmount;
    }
}
