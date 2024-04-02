package banking.account.service;

import banking.account.domain.BasicAccount;
import banking.account.domain.SavingAccount;
import banking.account.dto.AccountDTO;
import banking.account.repository.CentralBank;
import banking.account.constant.AccountName;
import banking.account.repository.Repository;

import java.math.BigDecimal;

import static banking.account.constant.AccountName.BASIC;
import static banking.account.constant.AccountName.SAVING;

public class BankService implements Service {
    // 싱글톤 패턴
    private final Repository repository;
    private BasicAccount account;

    public BankService(Repository repository) {
        this.repository = repository;
    }

    public void deposit(String accountNum, BigDecimal depositAmount) {
        repository.deposit(accountNum, depositAmount);
    }

    public void withdraw(String accountNum, BigDecimal depositAmount) {
        repository.withdraw(accountNum, depositAmount);

    }

    public void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount) {
        repository.transfer(depositAccountNum,withdrawAccountNum,transferAmount);
    }

    @Override
    public void createAccount(AccountDTO accountDTO) {
        String targetAmount = accountDTO.getTargetAmount();
        if (targetAmount == null || targetAmount.isEmpty()) {
            createBasic(accountDTO);
        } else {
            createSaving(accountDTO);
        }
    }

    private void createBasic(AccountDTO accountDTO) {
        BasicAccount account = makeDomain(accountDTO);
        BasicAccount basicAccount = new BasicAccount(account.getAccountType(), account.getAccountNumber(), account.getOwner(), account.getBalance(), true);
        repository.createAccount(basicAccount);
    }

    private void createSaving(AccountDTO accountDTO) {
        BasicAccount account = makeDomain(accountDTO);
        BigDecimal targetAmount = new BigDecimal(accountDTO.getTargetAmount());
        SavingAccount savingAccount = new SavingAccount(account.getAccountType(), account.getAccountNumber(), account.getOwner(), account.getBalance(), true, targetAmount);
        repository.createAccount(savingAccount);
    }

    @Override
    public BasicAccount findAccount(String accountNumber) {
        return repository.findAccount(accountNumber);
    }

    private BasicAccount makeDomain(AccountDTO accountDTO) {
        AccountName accountType = getAccountType(accountDTO.getTypeNum());
        String accountNumber = accountDTO.getAccountNumber();
        String owner = accountDTO.getOwner();
        BigDecimal balance = new BigDecimal(accountDTO.getMoney());

        return new BasicAccount(accountType, accountNumber, owner, balance, true);
    }

    @Override
    public AccountName getAccountType(int accountType) {
        AccountName type = switch (accountType) {
            case 1: yield BASIC;
            case 2: yield SAVING;
            default: throw new IllegalStateException("Unexpected value: " + accountType);
        };
        return type;
    }


}
