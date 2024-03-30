package member;

public interface SavingsMemberRepository {
    void save(SavingsMember savingsMember);

    SavingsMember findByAccountNumber(String accountNumber);
}
