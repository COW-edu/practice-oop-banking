package org.bank;public class Account {    private String type;    private int AccountNumber;    private String name;    private int Balance;    private String isActivated;    public Account(String type, int AccountNumber, String name, int Balance, String isActivated) {        this.type = type;        this.AccountNumber = AccountNumber;        this.name = name;        this.Balance = Balance;        this.isActivated = isActivated;    }    public String getType() { return type; }    public void setType(String type) { this.type = type; }    public int getAccountNumber() { return AccountNumber; }    public void setType(int AccountNumber) { this.AccountNumber = AccountNumber; }    public String getName() { return name; }    public void setName(String name) { this.name = name; }    public int getBalance() { return Balance; }    public void setBalance(int Balance) { this.Balance = Balance; }    public String getIsActivated() { return isActivated; }    public void setIsActivated(String isActivated) { this.isActivated = isActivated; }}