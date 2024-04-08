package model;

import java.math.BigDecimal;

public interface Account {
    String getBankAccountNumber();
    BigDecimal getAmount();
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    String toString();
}
