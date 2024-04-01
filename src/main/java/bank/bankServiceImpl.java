package bank;

import java.math.BigDecimal;

public class bankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public bankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void join(GeneralMember generalMember) {
        bankRepository.save(generalMember);
    }

    @Override
    public void deposit(String accountNumber, BigDecimal depositAmount) {
        bankRepository.addAmount(accountNumber,depositAmount);

    }

    @Override
    public void withdraw(String accountNumber, BigDecimal withdrawAmount) {
        GeneralMember generalMember=  bankRepository.findByAccountNumber(accountNumber);
        if (generalMember instanceof SavingsMember && ((SavingsMember) generalMember).getGoalAmount().compareTo(((SavingsMember) generalMember).getAmount()) > -1) {
            return;
        }
        bankRepository.subtractAmount(accountNumber,withdrawAmount);
    }

    @Override
    public GeneralMember getAccountInfo(String accountNumber) {
        return bankRepository.findByAccountNumber(accountNumber);

    }
}
