package member;

import java.util.HashMap;
import java.util.Map;

public class SavingsMemoryRepository implements SavingsMemberRepository {
    private  static Map<String, SavingsMember> store = new HashMap<>();
    @Override
    public void save(SavingsMember savingsMember) {
        store.put(savingsMember.getBankAccountNumber(), savingsMember);

    }

    @Override
    public SavingsMember findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
