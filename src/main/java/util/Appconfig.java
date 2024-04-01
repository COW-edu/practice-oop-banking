package util;

import interest.InterestServiceImpl;
import interest.InterestService;
import interestPolicy.InterestPolicy;
import interestPolicy.RateInterestPolicy;
import bank.*;

public class Appconfig {
    public BankService memberService(){
        return new bankServiceImpl(memberRepository());
    }
    public static BankRepository memberRepository(){
        return new BankMemoryRepository();

    }
    public InterestService bankService(){
        return new InterestServiceImpl(memberRepository(), interestPolicy());

    }
    public static InterestPolicy interestPolicy() {
        return new RateInterestPolicy();
    }
}
