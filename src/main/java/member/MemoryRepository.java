package member;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepository implements MemberRepository {
    private  static Map<String, GeneralMember> store = new HashMap<>();
    @Override
    public void save(GeneralMember generalMember) {
        store.put(generalMember.getBankAccountNumber(), generalMember);
    }

    @Override
    public GeneralMember findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
