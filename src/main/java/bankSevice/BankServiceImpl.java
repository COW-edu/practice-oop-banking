package bankSevice;

import BankRepository.BankRepository;
import model.Account;
import model.AccountBuilder;

import java.math.BigDecimal;
import java.util.List;

public class BankServiceImpl implements BankService {
    private final static Integer GENERAL_ACCOUNT = 4;
    private final static Integer SAVINGS_ACCOUNT = 5;
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void join(List<String> account) {
        if (account.size() == GENERAL_ACCOUNT) {
            generalJoin(account);
        }
        if (account.size() == SAVINGS_ACCOUNT) {
            savingsJoin(account);
        }
    }

    @Override
    public void generalJoin(List<String> account) {
        AccountBuilder builder = setUpAccountBuilder(account);
        bankRepository.save(builder.buildGeneralAccount());
    }

    @Override
    public void savingsJoin(List<String> account) {
        AccountBuilder builder = setUpAccountBuilder(account).goalAmount(new BigDecimal(account.get(4)));
        bankRepository.save(builder.buildSavingsAccount());
    }

    @Override
    public AccountBuilder setUpAccountBuilder(List<String> account) {
        return new AccountBuilder().accountType(account.get(0)).name(account.get(1)).bankAccountNumber(account.get(2)).amount(new BigDecimal(account.get(3))).activation(true);
    }


    @Override
    public void deposit(String accountNumber, BigDecimal depositAmount) {
        Account account = bankRepository.getAccount(accountNumber);
        account.deposit(depositAmount);
    }

    @Override
    public void withdraw(String accountNumber, BigDecimal withdrawAmount) {
        Account account = bankRepository.getAccount(accountNumber);
        account.withdraw(withdrawAmount);
    }

    @Override
    public void disableAccount(String accountNumber) {
        Account account = bankRepository.getAccount(accountNumber);
        account.disableAccount();
    }

    @Override
    public Account getAccountInfo(String accountNumber) {
        return bankRepository.getAccount(accountNumber);
    }
}
