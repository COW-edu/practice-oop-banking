package bankSevice;

import BankRepository.BankRepository;

import java.math.BigDecimal;
import java.util.List;

public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void join(List<String> account) {
        if (account.size() == 4) {
            generalJoin(account);
        }
        if (account.size() == 5) {
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
        AccountBuilder builder = setUpAccountBuilder(account)
                .goalAmount(new BigDecimal(account.get(4)));
        bankRepository.save(builder.buildSavingsAccount());
    }

    @Override
    public AccountBuilder setUpAccountBuilder(List<String> account) {
        return new AccountBuilder()
                .accountType(account.get(0))
                .name(account.get(1))
                .bankAccountNumber(account.get(2))
                .amount(new BigDecimal(account.get(3)))
                .activation(true);
    }


    @Override
    public void deposit(String accountNumber, BigDecimal depositAmount) {
        bankRepository.addAmount(accountNumber,depositAmount);
    }

    @Override
    public void withdraw(String accountNumber, BigDecimal withdrawAmount) {
        bankRepository.subtractAmount(accountNumber,withdrawAmount);
    }

    @Override
    public GeneralAccount getAccountInfo(String accountNumber) {
        return bankRepository.findByAccountNumber(accountNumber);

    }
}
