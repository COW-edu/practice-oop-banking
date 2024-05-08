package org.example.account;


import java.math.BigDecimal;


public class Account {

    public static int howmanyaccout = 0;
    public String id;
    public String pw;
    protected String category;
    protected String accountNum;
    protected BigDecimal balance = new BigDecimal(0);
    protected String owner;
    protected boolean isVaild;



    public Account(String id,String pw, String owner, String accountNum, String category, BigDecimal balance) {
        this.id =id;
        this.pw= pw;
        this.owner = owner;
        this.accountNum =accountNum;
        this.category=category;
        this.balance=balance;
        howmanyaccout++;
    }

    public boolean SuccessLogin(String id, String pw) {
        boolean ok = false; //2번
        if (this.id.equals(id) && this.pw.equals(pw)) {
            ok = true;
        }
        return ok;
    }

    public void add(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void minus(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }


    public boolean isVaild() {
        return isVaild;
    }

    public void setVaild(boolean vaild) {
        isVaild = vaild;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static int getHowmanyaccout() {
        return howmanyaccout;
    }

    public static void setHowmanyaccout(int howmanyaccout) {
        Account.howmanyaccout = howmanyaccout;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }





    }