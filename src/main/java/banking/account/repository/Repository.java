package banking.account.repository;

import banking.account.domain.BasicAccount;

import java.math.BigDecimal;

public interface Repository {
    void createAccount(BasicAccount account);
    BasicAccount findAccount(String accountNum);
    void deposit(String accountNum, BigDecimal depositAmount);
    void withdraw(String accountNum, BigDecimal depositAmount);
    void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount);

}
