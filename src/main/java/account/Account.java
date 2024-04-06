package account;

import message.ErrorMessage;
import interest.InterestCalculator;
import lombok.AllArgsConstructor;
import message.SuccessMessage;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class Account {

    private static final boolean ACCOUNT_STATUS_ACTIVE = true;

    protected InterestCalculator interestCalculator;
    protected String type;
    protected String accountNum;
    protected String name;
    protected BigDecimal balance;
    protected BigDecimal target;
    protected boolean status;


    public String deposit(BigDecimal balance) {
        BigDecimal interest = interestCalculator.getInterest(balance);
        this.balance = this.balance.add(balance.add(interest));
        return String.format(SuccessMessage.DEPOSIT_COMPLETE.getSuccessMessage(), this.balance);
    }

    public String withdraw(BigDecimal balance) throws IllegalStateException {
        if (checkBalanceForWithdrawal(balance)) {
            this.balance = this.balance.subtract(balance);
            return String.format(SuccessMessage.WITHDRAW_COMPLETE.getSuccessMessage(), this.balance);
        }
        throw new IllegalStateException(String.format(ErrorMessage.INSUFFICIENT_BALANCE.getErrorMessage(), this.balance));
    }

    public String withdrawForTransfer(BigDecimal balance) throws IllegalStateException {
        if (checkBalanceForWithdrawal(balance)) {
            this.balance = this.balance.subtract(balance);
            return String.format(SuccessMessage.REMITTANCE_COMPLETE.getSuccessMessage(), this.balance);
        }
        throw new IllegalStateException(String.format(ErrorMessage.INSUFFICIENT_BALANCE.getErrorMessage(), this.balance));
    }

    public String changeStatus() {
        if (status == ACCOUNT_STATUS_ACTIVE) {
            this.status = false;
            return SuccessMessage.ACCOUNT_INACTIVE.getSuccessMessage();
        }
        this.status = true;
        return SuccessMessage.ACCOUNT_ACTIVE.getSuccessMessage();
    }

    public void depositForTransfer(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    public String getAccountInfo() {
        return String.format(SuccessMessage.DISPLAY_ACCOUNT_INFO.getSuccessMessage(),
                this.type, this.accountNum, this.name, this.balance, this.status ? SuccessMessage.ACCOUNT_ACTIVE.getSuccessMessage() : SuccessMessage.ACCOUNT_INACTIVE.getSuccessMessage());
    }

    public void setInitAccountNum(String accountNum) {
        if (this.accountNum == null){
            this.accountNum = accountNum;
        }
    }

    public boolean isAccountActive() {
        return this.status;
    }

    private boolean checkBalanceForWithdrawal(BigDecimal balance) {
        return this.balance.compareTo(balance) >= 0;
    }
}
