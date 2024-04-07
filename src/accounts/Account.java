package accounts;

import java.math.BigDecimal;

public abstract class Account {
    protected String accountType;
    protected String accountNum;
    protected String owner;
    protected BigDecimal amount;
    protected boolean activated;

    public Account(String owner, String accountNum, String accountType, BigDecimal amount) {
        this.accountType = accountType;
        this.accountNum = accountNum;
        this.owner = owner;
        this.amount = amount;
        this.activated = true;
    }

    public String getAccountInfo() { // 계좌 정보 출력
        return "*************************\n" +
                "Owner : " + owner + "\n" +
                "AccountInfo.Account Type : " + accountType + "\n" +
                "Activated : " + (activated ? "Yes" : "No") + "\n" +
                "AccountInfo.Account Number : " + accountNum + "\n" +
                "Asset : ₩" + amount;

    }

    public boolean isExist(String accountNum) {
        return accountNum.equals(accountNum);
    }
    public abstract boolean withdraw(BigDecimal withdrawAmount);
    public abstract boolean deposit(BigDecimal depositAmount);
}
