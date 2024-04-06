package BankRepository;

import bankSevice.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankMemoryRepository implements BankRepository {
    private static final Map<String, Account> store = new HashMap<>();
    @Override
    public void save(Account account) {
        store.put(account.getBankAccountNumber(), account);
    }


    @Override
    public void addAmount(String accountNumber, BigDecimal depositAmount) {
        Account account = store.get(accountNumber);
        account.setAmount(account.getAmount().add(depositAmount));
    }

    @Override
    public void subtractAmount(String accountNumber, BigDecimal withdrawAmount) {
        Account member = store.get(accountNumber);
        member.setAmount(member.getAmount().subtract(withdrawAmount));
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
