package member;

public class MemberAppconfig {
    public DepositMemberService depositMemberService(){
        return new DepositServiceImpl(depositMemberRepository());
    }
    public static DepositMemberRepository depositMemberRepository(){
        return new MemoryDepsitRepository();

    }
}
