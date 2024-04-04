package util;

import BankRepository.BankRepository;
import interest.InterestServiceImpl;
import interest.InterestService;
import interest.InterestPolicy;
import interest.RateInterestPolicy;
import bankSevice.*;
import BankRepository.BankMemoryRepository;

public class Appconfig {
    public BankService bankService(){
        return new BankServiceImpl(bankRepository());
    }
    public static BankRepository bankRepository(){
        return new BankMemoryRepository();
    }
    public InterestService interBankService(){
        return new InterestServiceImpl(bankRepository(), interestPolicy());
    }
    public static InterestPolicy interestPolicy() {
        return new RateInterestPolicy();
    }
}
