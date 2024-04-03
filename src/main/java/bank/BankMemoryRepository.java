package bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankMemoryRepository implements BankRepository {
    private static final Map<String, GeneralMember> store = new HashMap<>();
    @Override
    public void save(GeneralMember generalMember) {
        store.put(generalMember.getBankAccountNumber(), generalMember);
    }

    @Override
    public void addAmount(String accountNumber, BigDecimal depositAmount) {
        GeneralMember member = store.get(accountNumber);
        member.setAmount(member.getAmount().add(depositAmount));
    }

    @Override
    public void subtractAmount(String accountNumber, BigDecimal withdrawAmount) {
        GeneralMember member = store.get(accountNumber);
        member.setAmount(member.getAmount().subtract(withdrawAmount));
    }

    @Override
    public GeneralMember findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
