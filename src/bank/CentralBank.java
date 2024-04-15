package bank;

import accounts.Account;
import accounts.NormalAccount;
import accounts.SavingAccount;
import interest.AccountInterest;
import interest.InterestCalculator;
import interest.SavingAccountInterest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CentralBank {
    private final List<Account> accounts;
    private final Map<String, InterestCalculator> calculateInterest;
    private final Pattern pattern = Pattern.compile("\\d{6}-\\d{2}-\\d{6}");

    public CentralBank() {
        accounts = new ArrayList<>();
        calculateInterest = new HashMap<>();
        calculateInterest.put("N", new AccountInterest());
        calculateInterest.put("S", new SavingAccountInterest());
    }

    public void createNormalAccount(String name, String accountNum, String accountType, BigDecimal amount) {
        Matcher m = pattern.matcher(accountNum);

        // 입력값이 유효한지 확인합니다.
        if (!m.matches() || amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Wrong Input Value. Failed Create Account");
            return;
        }

        // 계좌를 생성하고 리스트에 추가합니다.
        Account normalAccount = new NormalAccount(name, accountNum, accountType, amount);
        accounts.add(normalAccount);
        System.out.println("Successfully Create Normal Account!");
    }

    public void createSavingAccount(String name, String accountNum, String accountType, BigDecimal currentAmount, BigDecimal goalAmount) {
        Matcher m = pattern.matcher(accountNum);

        // 입력값이 유효한지 확인합니다.
        if (!m.matches() || currentAmount == null || goalAmount == null
                || currentAmount.compareTo(BigDecimal.ZERO) < 0 || goalAmount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Wrong Input Value. Failed Create Account");
            return;
        }

        // 계좌를 생성하고 리스트에 추가합니다.
        Account savingAccount = new SavingAccount(name, accountNum, accountType, currentAmount, goalAmount);
        accounts.add(savingAccount);
        System.out.println("Successfully Create Saving Account!");
    }

    public void transfer(String senderAccountNum, String receiverAccountNum, BigDecimal sendAmount) { // 송금
        Account sender = null;
        Account receiver = null;

        for (Account account : accounts) { // 출금계좌와 입금계좌가 존재하는지 확인
            if (account.isExist(senderAccountNum)) {
                sender = account;
            }
            if (account.isExist(receiverAccountNum)) {
                receiver = account;
            }
        }

        if (sender != null && receiver != null) {
            if (sender.amountIsBiggerThanWithdrawAmount(sendAmount)) {
                sender.minusAmount(sendAmount);

                if (receiver.amountIsBiggerThanWithdrawAmount(sendAmount)) {
                    receiver.plusAmount(sendAmount);
                }
            } else {
                System.out.println("Your amount is lower than withdrawAmount");
            }
        }
        System.out.println("Transfer Finished! From " + senderAccountNum + " to "
                + receiverAccountNum + " amount " + sendAmount);
    }

    public void withDraw(String accountNum, BigDecimal amount) {
        accounts.stream()
                .filter(a -> a.isExist(accountNum))
                .filter(a -> a.amountIsBiggerThanWithdrawAmount(amount))
                .forEach(a -> a.minusAmount(amount));
    }

    public void deposite(String accountNum, BigDecimal amount) {
        accounts.stream()
                .filter(a -> a.isExist(accountNum))
                .forEach(a -> a.plusAmount(amount));
    }

    public void printAccountInfo(String accountNum) {
        for (Account a : accounts) {
            if (a.isExist(accountNum)) {
                System.out.println(a.getAccountInfo());
            }
        }
    }
}
