package member;

import java.util.HashMap;
import java.util.Map;

public class DepositMemoryRepository implements DepositMemberRepository {
    private  static Map<String, DepositMember> store = new HashMap<>();
    @Override
    public void save(DepositMember depositMember) {
        store.put(depositMember.getBankAccountNumber(), depositMember);
    }

    @Override
    public DepositMember findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
