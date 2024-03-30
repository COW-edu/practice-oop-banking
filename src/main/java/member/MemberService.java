package member;

public interface MemberService {
    void join(GeneralMember generalMember);
    GeneralMember getAccountInfo(String accountNumber);


}
