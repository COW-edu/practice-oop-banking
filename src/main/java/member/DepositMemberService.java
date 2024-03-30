package member;

public interface DepositMemberService {
    void join(DepositMember depositMember);
    DepositMember getAccountInfo(String accountNumber);


}
