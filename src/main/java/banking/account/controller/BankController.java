package banking.account.controller;

import banking.account.domain.BasicAccount;
import banking.account.dto.AccountDTO;
import banking.account.service.BankService;
import banking.account.service.Service;

import java.math.BigDecimal;


public class BankController {
    // 싱글톤 패턴
    public static final BankController bankController = new BankController();
    private Service bankservice = BankService.getInstance();

    public static BankController getInstance() { return bankController; }

    public BasicAccount findAccount(String accountNumber) {
        return bankservice.findAccount(accountNumber);
    }

    public void createAccount(AccountDTO accountDTO) {
        bankservice.createAccount(accountDTO);
    }


    public void deposit(String accountNum, BigDecimal depositAmount) {
        bankservice.deposit(accountNum, depositAmount);
    }

    public void withdraw(String accountNum, BigDecimal depositAmount) {
        bankservice.withdraw(accountNum, depositAmount);

    }

    public void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount) {
        bankservice.transfer(depositAccountNum,withdrawAccountNum,transferAmount);
    }
}
