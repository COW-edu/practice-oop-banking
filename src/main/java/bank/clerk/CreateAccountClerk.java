package bank.clerk;

import account.Account;
import account.AccountType;
import account.SavingsAccount;
import account.InstallmentSavingsAccount;
import bank.BankSystem;
import interest.SavingsInterest;
import interest.InstallmentSavingsInterest;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreateAccountClerk implements Clerk {

    private static final String CLERK_REQUEST = "개설하실 계좌 유형을 작성해주세요 ex) 예금 계좌, 적금 계좌";
    private static final String REQUEST_NAME = "성함을 작성해주세요.";
    private static final String DEPOSIT_ACCOUNT_CREATED = "예금 계좌가 생성되었습니다. 계좌번호는 [%s] 입니다.%n";
    private static final String SAVING_ACCOUNT_CREATED = "적금 계좌가 생성되었습니다. 계좌번호는 [%s] 입니다.%n";
    private static final String PROMPT_TARGET_AMOUNT = "목표금액을 설정해주세요";
    private static final String DEPOSIT_ACCOUNT_TYPE = "예금 계좌";
    private static final String SAVING_ACCOUNT_TYPE = "적금 계좌";
    private static final String TEMP_VALUE = "";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        validateAccountType();
    }

    private void validateAccountType() {
        while (true) {
            try {
                String input = getUserInput();
                AccountType accountType = AccountType.fromDescription(input);
                switch (accountType) {
                    case DEPOSIT -> createAccount(AccountType.DEPOSIT, null);
                    case SAVING -> {
                        BigDecimal target = promptForTargetAmount();
                        createAccount(AccountType.SAVING, target);
                    }
                }
                break;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createAccount(AccountType type, BigDecimal targetAmount) {
        String name = getName();
        Account account;
        if (type == AccountType.SAVING) {
            account = new InstallmentSavingsAccount(new InstallmentSavingsInterest(), SAVING_ACCOUNT_TYPE, TEMP_VALUE, name, BigDecimal.ZERO, targetAmount, true);
        } else {
            account = new SavingsAccount(new SavingsInterest(), DEPOSIT_ACCOUNT_TYPE, TEMP_VALUE, name, BigDecimal.ZERO, null, true);
        }
        String accountNumber = bankSystem.createAccount(account);
        System.out.printf(type == AccountType.SAVING ? SAVING_ACCOUNT_CREATED : DEPOSIT_ACCOUNT_CREATED, accountNumber);
    }

    private BigDecimal promptForTargetAmount() throws NumberFormatException {
        System.out.println(PROMPT_TARGET_AMOUNT);
        return new BigDecimal(String.valueOf(ValidationUtils.createBalance(getUserInput())));
    }

    private String getName() {
        System.out.println(REQUEST_NAME);
        return getUserInput();
    }
}