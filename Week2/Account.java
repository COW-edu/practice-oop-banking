package Week2;

import java.math.BigDecimal;

public interface Account { //
    String getAccountInfo();
    void withdraw(BigDecimal value);
    void deposit(BigDecimal value);
    String getAccountNumber();
    AccountType getAccountType();
    BigDecimal getBalance();
    void eraseStringBuilder();

//    void setBalance(BigDecimal balance);
}