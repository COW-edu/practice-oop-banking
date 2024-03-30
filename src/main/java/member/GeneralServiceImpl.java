package member;

public class GeneralServiceImpl implements GeneralMemberService {
    private final GeneralMemberRepository generalMemberRepository;

    public GeneralServiceImpl(GeneralMemberRepository generalMemberRepository) {
        this.generalMemberRepository = generalMemberRepository;
    }

    @Override
    public void join(GeneralMember generalMember) {
        generalMemberRepository.save(generalMember);
    }

    @Override
    public GeneralMember getAccountInfo(String accountNumber) {
        return generalMemberRepository.findByAccountNumber(accountNumber);

    }
}
