package bank;

import accountfile.Account;
import accountfile.SavingAccount;
import exception.DepositException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    protected static Scanner scanner = new Scanner(System.in);
    static int INIT_ACCOUNT_NUMBER = 0;
    protected static int seq = INIT_ACCOUNT_NUMBER;//<- 추가되는 계좌 개수
    public static DecimalFormat df = new DecimalFormat("#,###");//<- 숫자 포멧팅
    private HashMap<String, InterestCalculator> interestCalculators = new HashMap<>();

    public Bank(){
        interestCalculators.put("N", new NormalInterestCalculator());
        interestCalculators.put("S", new SavingInterestCalculator());
    }

    //기능 구현
    public class BankService {

        private Scanner scanner = new Scanner(System.in);

        public Account getAccount() {
            System.out.println("출금계좌를 입력하세요.");
            String accountNumber = scanner.next();
            return findAccount(accountNumber);
        }

        public BigDecimal getWithdrawAmount() {
            System.out.println("출금 금액을 입력하세요");
            return scanner.nextBigDecimal();
        }

        public void withdraw(Account account, BigDecimal value) {
            if (account.getAccountType().equals("s")) {
                new SavingBank().withdraw((SavingAccount) account);
            }
            BigDecimal result = account.withdraw(value);
            System.out.println("출금액 %s원이 정상적으로 출금되었습니다.");
        }

        public void calculateInterest(Account account) {
            BigDecimal interest = interestCalculators.get(account.getAccountType()).getInterest(account.getBalance());
            System.out.println("이자 %s원이 발생하였습니다.");
        }

        public void deposit() {
            System.out.println("입금계좌를 입력하세요.");
            String accountNumber = scanner.next();
            Account account = findAccount(accountNumber);

            System.out.println("입금 금액을 입력하세요");
            BigDecimal value = scanner.nextBigDecimal();
            try {
                account.deposit(value);
            } catch (DepositException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("입금액 %s원이 정상적으로 입금되었습니다.\n", value);
        }

        public void transfer() {
            System.out.println("출금계좌를 입력하세요.");
            String fromAccountNumber = scanner.next();
            Account fromAccount = findAccount(fromAccountNumber);

            System.out.println("입금계좌를 입력하세요.");
            String toAccountNumber = scanner.next();
            Account toAccount = findAccount(toAccountNumber);

            System.out.println("송금 금액을 입력하세요");
            BigDecimal value = scanner.nextBigDecimal();

            if (fromAccount.getAccountType().equals("s")) {
                new SavingBank().withdraw((SavingAccount) fromAccount);
            }

            BigDecimal result = fromAccount.withdraw(value);
            try {
                toAccount.deposit(value);
            } catch (DepositException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("송금액 %s원이 정상적으로 처리되었습니다.\n", value);
        }

        public void createAccount() {
            System.out.println("계좌 번호를 입력하세요.");
            String accountNumber = scanner.next();

            System.out.println("초기 입금액을 입력하세요");
            BigDecimal initialDeposit = scanner.nextBigDecimal();

            Account newAccount = new Account(accountNumber, initialDeposit);
            addAccount(newAccount);

            System.out.printf("계좌 번호 %s에 초기 입금액 %s원으로 계좌가 생성되었습니다.\n", accountNumber, initialDeposit);
        }

        private void addAccount(Account account) {
            // 계좌 리스트에 새로운 계좌를 추가
        }
    }

    private Account findAccount(String accountNumber) {
        return null;
    }
}
