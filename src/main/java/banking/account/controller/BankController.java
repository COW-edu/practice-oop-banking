package banking.account.controller;

import banking.account.domain.BasicAccount;
import banking.account.dto.AccountDTO;
import banking.account.service.BankService;
import banking.account.service.Service;

import java.math.BigDecimal;


public class BankController {
    // 싱글톤 패턴
    public  final Service service;

    public BankController(Service service) {
        this.service = service;
    }

    public BasicAccount findAccount(String accountNumber) {
        return service.findAccount(accountNumber);
    }

    public void createAccount(AccountDTO accountDTO) {
        service.createAccount(accountDTO);
    }


    public void deposit(String accountNum, BigDecimal depositAmount) {
        service.deposit(accountNum, depositAmount);
    }

    public void withdraw(String accountNum, BigDecimal depositAmount) {
        service.withdraw(accountNum, depositAmount);

    }

    public void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount) {
        service.transfer(depositAccountNum,withdrawAccountNum,transferAmount);
    }
}
