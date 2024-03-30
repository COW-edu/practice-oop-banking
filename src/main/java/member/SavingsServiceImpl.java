package member;

public class SavingsServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public SavingsServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(GeneralMember generallMember) {
        SavingsMember savingsMember = (SavingsMember) generallMember;
        memberRepository.save(savingsMember);
    }

    @Override
    public SavingsMember getAccountInfo(String accountNumber) {
        return (SavingsMember) memberRepository.findByAccountNumber(accountNumber);
    }
}
