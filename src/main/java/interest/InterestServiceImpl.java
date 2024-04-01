package interest;

import interestPolicy.InterestPolicy;
import bank.BankRepository;

import java.math.BigDecimal;

public class InterestServiceImpl implements InterestService {

    private final BankRepository bankRepository;
    private final InterestPolicy interestPolicy;

    public InterestServiceImpl(BankRepository bankRepository, InterestPolicy interestPolicy) {
        this.bankRepository = bankRepository;
        this.interestPolicy = interestPolicy;
    }

    @Override
    public Bank getInterestEstimated(String accountNumber) {
        BigDecimal InterestAmount = interestPolicy.interest(bankRepository.findByAccountNumber(accountNumber));
        return new Bank(InterestAmount);
    }
}
