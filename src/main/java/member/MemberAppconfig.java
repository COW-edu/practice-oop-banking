package member;

public class MemberAppconfig {
    public DepositMemberService depositMemberService(){
        return new DepositServiceImpl(depositMemberRepository());
    }
    public static DepositMemberRepository depositMemberRepository(){
        return new DepositMemoryRepository();

    }
    public SavingsMemberService savingsMemberService(){
        return new SavingsServiceImpl(savingsMemberRepository());
    }
    public static SavingsMemberRepository savingsMemberRepository(){
        return new SavingsMemoryRepository();

    }
}
