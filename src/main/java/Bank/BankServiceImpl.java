package Bank;

import interest.InterestPolicy;
import member.MemberRepository;
import member.MemberService;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {

    private final MemberRepository memberRepository;
    private final InterestPolicy interestPolicy;

    public BankServiceImpl(MemberRepository memberRepository, InterestPolicy interestPolicy) {
        this.memberRepository = memberRepository;
        this.interestPolicy = interestPolicy;
    }

    @Override
    public Bank getInterestEstimated(String accountNumber) {
        BigDecimal InterestAmount = interestPolicy.interest(memberRepository.findByAccountNumber(accountNumber));
        return new Bank(InterestAmount);
    }
}
