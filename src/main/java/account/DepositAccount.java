package account;

import interest.DepositInterest;
import interest.InterestCalculator;
import exception.account.InsufficienBalancetException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositAccount implements Account{

    private static final String DEPOSIT_COMPLETE = "입금완료! [잔고] = %s";
    private static final String WITHDRAW_COMPLETE = "출금완료! [잔고] = %s";
    private static final String INSUFFICIENT_BALANCE = "잔액부족! [잔고] = %s";
    private static final String REMITTANCE_COMPLETE = "송금완료! [잔고] = %s";
    private static final String ACCOUNT_INACTIVE = "[계좌상태] = 비활성화";
    private static final String ACCOUNT_ACTIVE = "[계좌상태] = 활성화";
    private static final String DISPLAY_ACCOUNT_INFO = "[계좌유형] = %s [계좌번호] = %s [소유자] = %s [잔액] = %s [활성화 여부] = %s";

    InterestCalculator interestCalculator = new DepositInterest();
    private String type;
    private String accountNum;
    private String name;
    private BigDecimal balance;
    private boolean status;

    public DepositAccount(String type, String accountNum, String name, BigDecimal balance, boolean status) {
        this.type = type;
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;
        this.status = status;
    }

    @Override
    public String deposit(BigDecimal balance){
        BigDecimal interest = interestCalculator.getInterest(balance);
        setBalance(getBalance().add(balance.add(interest)));
        return String.format(DEPOSIT_COMPLETE, getBalance());
    }
    @Override
    public String withdraw(BigDecimal balance) throws InsufficienBalancetException {
        if (validateBalance(balance)) {
            setBalance(getBalance().subtract(balance));
            return String.format(WITHDRAW_COMPLETE, getBalance());}
        throw new InsufficienBalancetException(String.format(INSUFFICIENT_BALANCE, getBalance()));
    }
    @Override
    public String withdrawForTransfer(BigDecimal balance) throws InsufficienBalancetException {
        if (validateBalance(balance)) {
            setBalance(getBalance().subtract(balance));
            return String.format(REMITTANCE_COMPLETE, getBalance());}
        throw new InsufficienBalancetException(String.format(INSUFFICIENT_BALANCE, getBalance()));
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public String changeStatus() {
        if(status){
         setStatus(false); return ACCOUNT_INACTIVE;
        }setStatus(true); return ACCOUNT_ACTIVE;
    }

    @Override
    public String getAccountInfo() {
        return String.format(DISPLAY_ACCOUNT_INFO,
                getType(), getAccountNum(), getName(), getBalance(), getStatus() ? ACCOUNT_ACTIVE : ACCOUNT_INACTIVE);
    }

    @Override
    public void depositForTransfer(BigDecimal balance) {
        setBalance(getBalance().add(balance));
    }
    public boolean validateBalance(BigDecimal balance) {
        return this.getBalance().compareTo(balance) >= 0;
    }
}
