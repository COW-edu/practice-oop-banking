package accounts;

import java.math.BigDecimal;

public abstract class Account {
    protected String owner;
    protected String accountNum;
    protected String accountType;
    protected BigDecimal amount;
    protected boolean activated;

    public Account(String owner, String accountNum, String accountType, BigDecimal amount) {
        this.owner = owner;
        this.accountNum = accountNum;
        this.accountType = accountType;
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

    public boolean amountIsBiggerThanWithdrawAmount(BigDecimal withdrawAmount) { // 예산 > 출금 금액인 경우
        return amount.compareTo(withdrawAmount) >= 0;
    }

    public boolean isExist(String accountNum) {
        return accountNum.equals(accountNum);
    }

    public abstract void minusAmount(BigDecimal withdrawAmount);

    public abstract void plusAmount(BigDecimal depositAmount);
}
