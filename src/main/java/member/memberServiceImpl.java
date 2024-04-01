package member;

import java.math.BigDecimal;

import static interest.InterestList.OVERONE;

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
    public void deposit(String accountNumber, BigDecimal depositAmount) {
        memberRepository.addAmount(accountNumber,depositAmount);

    }

    @Override
    public void withdraw(String accountNumber, BigDecimal withdrawAmount) {
        GeneralMember generalMember=  memberRepository.findByAccountNumber(accountNumber);
        if (generalMember instanceof SavingsMember && ((SavingsMember) generalMember).getGoalAmount().compareTo(((SavingsMember) generalMember).getAmount()) > -1) {
            return;
        }
        memberRepository.subtractAmount(accountNumber,withdrawAmount);
    }

    @Override
    public GeneralMember getAccountInfo(String accountNumber) {
        return memberRepository.findByAccountNumber(accountNumber);

    }
}
