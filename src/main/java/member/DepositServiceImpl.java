package member;

public class DepositServiceImpl implements DepositMemberService{
    private final DepositMemberRepository depositMemberRepository;

    public DepositServiceImpl(DepositMemberRepository depositMemberRepository) {
        this.depositMemberRepository = depositMemberRepository;
    }

    @Override
    public void join(DepositMember depositMember) {
        depositMemberRepository.save(depositMember);
    }
}
