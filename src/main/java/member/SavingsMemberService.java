package member;

public interface SavingsMemberService {
    void join(SavingsMember savingsMember);
    SavingsMember getAccountInfo(String accountNumber);
}
