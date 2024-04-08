package interest;

import BankRepository.BankRepository;
import bankSevice.BankService;

import java.math.BigInteger;

public class InterestServiceImpl implements InterestService {
    private final BankService bankService;
    private final InterestPolicy interestPolicy;

    public InterestServiceImpl(BankService bankService, InterestPolicy interestPolicy) {
        this.bankService = bankService;
        this.interestPolicy = interestPolicy;
    }
    @Override
    public BigInteger getInterestEstimated(String accountNumber) {
        return interestPolicy.interest(bankService.getAccountInfo(accountNumber)).toBigInteger();
    }
}
