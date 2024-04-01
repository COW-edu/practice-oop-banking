package account;

import exception.account.BelowTargetException;
import exception.account.InsufficienBalancetException;

import java.math.BigDecimal;


public interface Account {

    boolean getStatus();
    void setAccountNum(String accountNum);

    String deposit(BigDecimal balance);

    String withdraw(BigDecimal balance) throws BelowTargetException, InsufficienBalancetException;

    String getAccountNum();

    void depositForTransfer(BigDecimal balance);

    String withdrawForTransfer(BigDecimal balance) throws BelowTargetException, InsufficienBalancetException;

    String changeStatus();

    String getAccountInfo();

    BigDecimal getBalance();
}
