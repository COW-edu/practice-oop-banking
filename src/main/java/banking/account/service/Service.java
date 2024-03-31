package banking.account.service;

import banking.account.constant.AccountName;
import banking.account.domain.BasicAccount;
import banking.account.dto.AccountDTO;

import java.math.BigDecimal;

public interface Service {
    BasicAccount findAccount(String accountNumber);
    void createAccount(AccountDTO accountDTO);
    AccountName getAccountType(int accountType);

    void deposit(String accountNum, BigDecimal depositAmount);
    void withdraw(String accountNum, BigDecimal depositAmount);
    void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount);
}
