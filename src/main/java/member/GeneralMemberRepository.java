package member;

public interface GeneralMemberRepository {
    void save(GeneralMember generalMember);

    GeneralMember findByAccountNumber(String accountNumber);
}
