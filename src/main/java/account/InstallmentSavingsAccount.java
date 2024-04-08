package account;

import message.ErrorMessage;
import interest.InterestCalculator;

import java.math.BigDecimal;

public class InstallmentSavingsAccount extends Account {

    private static final String WITHDRAW_COMPLETE = "출금완료! [잔고] = %s";
    private static final String REMITTANCE_COMPLETE = "송금완료! [잔고] = %s";
    private static final String ACCOUNT_INACTIVE = "[계좌상태] = 비활성화";
    private static final String ACCOUNT_ACTIVE = "[계좌상태] = 활성화";
    private static final String DISPLAY_ACCOUNT_INFO = "[계좌유형] = %s [계좌번호] = %s [소유자] = %s [잔액] = %s [목표금액] = %s [활성화 여부] = %s";

    public InstallmentSavingsAccount(InterestCalculator interestCalculator, String type, String accountNum, String name, BigDecimal balance, BigDecimal target, boolean status) {
        super(interestCalculator, type, accountNum, name, balance, target, status);
    }

    @Override
    public String withdraw(BigDecimal balance) throws IllegalStateException {
        if (checkBalanceForWithdrawal(balance) && checkTargetForWithdrawal()) {
            this.balance = this.balance.subtract(balance);
            return String.format(WITHDRAW_COMPLETE, this.balance);
        }
        if (checkBalanceForWithdrawal(balance) && !checkTargetForWithdrawal()) {
            throw new IllegalStateException(String.format(ErrorMessage.BELOW_TARGET.getErrorMessage(), this.balance));
        }
        throw new IllegalStateException(String.format(ErrorMessage.INSUFFICIENT_BALANCE.getErrorMessage(), this.balance));
    }

    @Override
    public String withdrawForTransfer(BigDecimal balance) throws IllegalStateException {
        if (checkBalanceForWithdrawal(balance) && checkTargetForWithdrawal()) {
            this.balance = this.balance.subtract(balance);
            return String.format(REMITTANCE_COMPLETE, this.balance);
        }
        if (checkBalanceForWithdrawal(balance)) {
            throw new IllegalStateException(String.format(ErrorMessage.BELOW_TARGET.getErrorMessage(), this.balance));
        }
        throw new IllegalStateException(String.format(ErrorMessage.INSUFFICIENT_BALANCE.getErrorMessage(), this.balance));
    }

    @Override
    public String getAccountInfo() {
        return String.format(DISPLAY_ACCOUNT_INFO,
                this.type, this.accountNumber, this.name, this.balance, this.target, this.status ? ACCOUNT_ACTIVE : ACCOUNT_INACTIVE);
    }

    private boolean checkBalanceForWithdrawal(BigDecimal balance) {
        return this.balance.compareTo(balance) >= 0;
    }

    public boolean checkTargetForWithdrawal() {
        return this.target.compareTo(this.balance) < 0;
    }
}
