package BankRepository;

import bankSevice.GeneralAccount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankMemoryRepository implements BankRepository {
    private static final Map<String, GeneralAccount> store = new HashMap<>();
    @Override
    public void save(GeneralAccount generalAccount) {
        store.put(generalAccount.getBankAccountNumber(), generalAccount);
    }

    @Override
    public void addAmount(String accountNumber, BigDecimal depositAmount) {
        GeneralAccount member = store.get(accountNumber);
       // member.setAmount(member.getAmount().add(depositAmount));
    }

    @Override
    public void subtractAmount(String accountNumber, BigDecimal withdrawAmount) {
        GeneralAccount member = store.get(accountNumber);
       // member.setAmount(member.getAmount().subtract(withdrawAmount));
    }

    @Override
    public GeneralAccount findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
