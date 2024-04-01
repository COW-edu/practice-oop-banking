package BankingSystem.account;

import BankingSystem.utility.Dialog;

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
    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(targetAmount)<0) {
            Dialog.systemMsg("잔액이 목표금액보다 적을 경우 출금할 수 없습니다.");
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public String getAccountInfo() {
        return super.getAccountInfo()+"\n목표금액 : " + targetAmount;
    }

    @Override
    public Account newAccount() {
        return new SaveAccount();
    }

}
