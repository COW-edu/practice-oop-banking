package member;

public class memberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public memberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(GeneralMember generalMember) {
        memberRepository.save(generalMember);
    }

    @Override
    public GeneralMember getAccountInfo(String accountNumber) {
        return memberRepository.findByAccountNumber(accountNumber);

    }
}
