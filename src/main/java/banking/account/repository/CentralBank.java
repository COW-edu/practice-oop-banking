package banking.account.repository;

import banking.account.constant.AccountName;
import banking.account.domain.BasicAccount;
import banking.account.domain.SavingAccount;
import banking.account.exception.InsufficientAmount;
import banking.account.exception.NoAccountException;
import banking.account.policy.InterestCalculator;
import banking.account.policy.NormalInterestCalculator;
import banking.account.policy.SavingInterestCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

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
    public void deposit(String accountNum, BigDecimal depositAmount) {
        BasicAccount basicAccount = accountInquiry(accountNum);
        basicAccount.setBalance(basicAccount.getBalance().add(depositAmount));
    }



    @Override
    public void withdraw(String accountNum, BigDecimal depositAmount) {
        // Saving 계좌의 검증
        boolean checkSavingAcc = validationSaving(accountNum, depositAmount);
        if (checkSavingAcc) {
            throw new InsufficientAmount("목표 금액이 충족되지 않았습니다.");
        }

        // 계좌 정보 가져오기
        BasicAccount basicAccount = accountInquiry(accountNum);
        basicAccount.setBalance(basicAccount.getBalance().subtract(depositAmount));
    }

    @Override
    public void transfer(String depositAccountNum, String withdrawAccountNum, BigDecimal transferAmount) {
        withdraw(withdrawAccountNum, transferAmount);
        deposit(depositAccountNum, transferAmount);
    }

    @Override
    public BasicAccount findAccount(String accountNum) {
        BasicAccount findAccount = accountMap.get(accountNum);
        BigDecimal interest = policy.get(findAccount.getAccountType()).getInterest(findAccount.getBalance());
        findAccount.setBalance((findAccount.getBalance().add(interest)));
        return findAccount;
    }

    private BasicAccount accountInquiry(String accountNum) {
        BasicAccount basicAccount = accountMap.get(accountNum);
        if (basicAccount == null) {
            throw new NoAccountException("계좌가 존재하지 않습니다: " + accountNum);
        }
        return basicAccount;
    }


    public boolean validationSaving(String accountNum, BigDecimal amount) {
        return Optional.ofNullable(accountMap.get(accountNum))
                .filter(account -> account instanceof SavingAccount) // instance 검사
                .map(account -> (SavingAccount) account) // SavingAccount로 형변환
                .filter(account -> account.getAccountType() == SAVING) // 계좌 타입 검사
                .filter(account -> account.getTargetAmount().compareTo(amount) > 0) // 목표 금액 비교
                .isPresent(); // 조건에 맞는 객체가 존재하면 true, 그렇지 않으면 false 반환
    }
}
