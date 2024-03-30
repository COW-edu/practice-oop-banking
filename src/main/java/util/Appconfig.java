package util;

import Bank.BankService;
import Bank.BankServiceImpl;
import interest.InterestPolicy;
import interest.RateInterestPolicy;
import member.*;

public class Appconfig {
    public MemberService memberService(){
        return new memberServiceImpl(memberRepository());
    }
    public static MemberRepository memberRepository(){
        return new MemoryRepository();

    }
    public BankService bankService(){
        return new BankServiceImpl(memberRepository(), interestPolicy());

    }
    public static InterestPolicy interestPolicy() {
        return new RateInterestPolicy();
    }
}
