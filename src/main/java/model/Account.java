package model;

import java.math.BigDecimal;

public interface Account {
    String getBankAccountNumber();
    BigDecimal getAmount();
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    void disableAccount();
    String toString();
}
