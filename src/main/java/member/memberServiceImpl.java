package member;

import java.math.BigDecimal;

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
        memberRepository.subtractAmount(accountNumber,withdrawAmount);
    }

    @Override
    public GeneralMember getAccountInfo(String accountNumber) {
        return memberRepository.findByAccountNumber(accountNumber);

    }
}
