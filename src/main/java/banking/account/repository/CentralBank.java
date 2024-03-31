package banking.account.repository;

import banking.account.constant.AccountName;
import banking.account.domain.BasicAccount;
import banking.account.policy.InterestCalculator;
import banking.account.policy.NormalInterestCalculator;
import banking.account.policy.SavingInterestCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import static banking.account.constant.AccountName.BASIC;
import static banking.account.constant.AccountName.SAVING;

public class CentralBank implements Repository {
    // 싱글톤 패턴
    private static final Repository centralBankRepo = new CentralBank();

    private static final HashMap<String, BasicAccount> accountMap = new HashMap<>();
    private static final HashMap<AccountName, InterestCalculator> policy = new HashMap<>();

    public static Repository getInstance() {
        policy.put(BASIC, new NormalInterestCalculator());
        policy.put(SAVING, new SavingInterestCalculator());
        return centralBankRepo;
    }


    @Override
    public void createAccount(BasicAccount account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    @Override
    public BasicAccount findAccount(String accountNum) {
        BasicAccount findAccount = accountMap.get(accountNum);
        BigDecimal interest = policy.get(findAccount.getAccountType()).getInterest(findAccount.getBalance());
        findAccount.setBalance((findAccount.getBalance().add(interest)));
        return findAccount;
    }

    @Override
    public void deposit(String accountNum, BigDecimal depositAmount) {
        BasicAccount basicAccount = accountMap.get(accountNum);
        basicAccount.setBalance(basicAccount.getBalance().add(depositAmount));
    }

    @Override
    public void withdraw(String accountNum, BigDecimal depositAmount) {
        BasicAccount basicAccount = accountMap.get(accountNum);
        basicAccount.setBalance(basicAccount.getBalance().subtract(depositAmount));
    }

    @Override
    public void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount) {
        BasicAccount depositAccount = accountMap.get(depositAccountNum);
        depositAccount.setBalance(depositAccount.getBalance().add(transferAmount));

        BasicAccount withdrawAccount = accountMap.get(withdrawAccountNum);
        withdrawAccount.setBalance(withdrawAccount.getBalance().subtract(transferAmount));
    }
}
