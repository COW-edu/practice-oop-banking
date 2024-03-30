package member;

public class SavingsServiceImpl implements SavingsMemberService {
    private final SavingsMemberRepository savingsMemberRepository;

    public SavingsServiceImpl(SavingsMemberRepository savingsMemoryRepository) {
        this.savingsMemberRepository = savingsMemoryRepository;
    }

    @Override
    public void join(SavingsMember savingsMember) {
        savingsMemberRepository.save(savingsMember);
    }

    @Override
    public SavingsMember getAccountInfo(String accountNumber) {
        return savingsMemberRepository.findByAccountNumber(accountNumber);
    }
}
