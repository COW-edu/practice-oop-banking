package member;

public interface MemberRepository {
    void save(GeneralMember generalMember);

    GeneralMember findByAccountNumber(String accountNumber);
}
