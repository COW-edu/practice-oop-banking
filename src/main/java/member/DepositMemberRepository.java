package member;

public interface DepositMemberRepository {
    void save(DepositMember depositMember);

    DepositMember findByAccountNumber(String accountNumber);
}
