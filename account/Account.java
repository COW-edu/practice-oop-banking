package account;

import java.math.BigDecimal;

public class Account {


    protected EAccount eAccount;
    protected String accountNum;
    protected String accountHolder;
    protected BigDecimal balance;
    protected boolean isActivate;


    public EAccount getEAccount() {
        return eAccount;
    }

    public void setEAccount(EAccount eAccount) {
        this.eAccount = eAccount;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }


    public Account(){
        this.eAccount = EAccount.N;
        this.balance = new BigDecimal(0);
        this.isActivate = true;
    }

    public Account(String accountHolder, String accountNum){
        this();
        this.accountHolder = accountHolder;
        this.accountNum = accountNum;
    }



    public String getAccountInfo(){
        return "계좌종류 : " + eAccount.information + "\n" +
                "계좌번호 : " + accountNum + "\n" +
                "예금주 : " + accountHolder + "\n" +
                "잔액 : " + balance + "\n" +
                "계좌상태 : " + (isActivate ? "활성화" : "비활성화");
    }


    public boolean deposit(BigDecimal amount){
        try {
            this.balance = balance.add(amount);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean withdraw(BigDecimal amount){
        try {
            this.balance = balance.subtract(amount);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Account newAccount(){
        return new Account();
    }


}




