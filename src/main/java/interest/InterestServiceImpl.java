package interest;

import BankRepository.BankRepository;

import java.math.BigDecimal;

public class InterestServiceImpl implements InterestService {
    private final BankRepository bankRepository;
    private final InterestPolicy interestPolicy;

    public InterestServiceImpl(BankRepository bankRepository, InterestPolicy interestPolicy) {
        this.bankRepository = bankRepository;
        this.interestPolicy = interestPolicy;
    }
    @Override
    public BigDecimal getInterestEstimated(String accountNumber) {
        return interestPolicy.interest(bankRepository.findByAccountNumber(accountNumber));
    }
}
