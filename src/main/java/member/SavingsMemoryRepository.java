package member;

import java.util.HashMap;
import java.util.Map;

public class SavingsMemoryRepository implements MemberRepository {
    private  static Map<String, GeneralMember> store = new HashMap<>();
    @Override
    public void save(GeneralMember generalMember) {
        SavingsMember savingsMember = (SavingsMember) generalMember;
        store.put(savingsMember.getBankAccountNumber(), savingsMember);

    }

    @Override
    public GeneralMember findByAccountNumber(String accountNumber) {
        return store.get(accountNumber);
    }
}
