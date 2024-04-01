package bank.clerk;

import account.Account;
import account.AccountType;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankSystem;
import exception.clerk.InputAccountTypeException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Scanner;

@RequiredArgsConstructor
public class CreateAccountClerk implements Clerk{
    private static final String CLERK_REQUEST = "개설하실 계좌 유형을 작성해주세요 ex) 예금 계좌, 적금 계좌";
    private static final String REQUEST_NAME = "성함을 작성해주세요.";
    private static final String DEPOSIT_ACCOUNT_CREATED = "예금 계좌가 생성되었습니다. 계좌번호는 [%s] 입니다.%n";
    private static final String SAVING_ACCOUNT_CREATED = "적금 계좌가 생성되었습니다. 계좌번호는 [%s] 입니다.%n";
    private static final String PROMPT_TARGET_AMOUNT = "목표금액을 설정해주세요";
    private static final String DEPOSIT_ACCOUNT_TYPE = "예금 계좌";
    private static final String SAVING_ACCOUNT_TYPE = "적금 계좌";
    private static final String TEMP_VALUE = "";

    private final BankSystem bankSystem;
    private final Scanner scanner = new Scanner(System.in);

    public void action() {
        System.out.println(CLERK_REQUEST);
        validateAccountType();
    }

    private void validateAccountType() {

        try{
            String input = getUserInput();
            AccountType accountType = AccountType.fromDescription(input);
            switch (accountType) {
                case DEPOSIT: createDepositAccount(); break;
                case SAVING: BigDecimal target = promptForTargetAmount(); createSavingAccount(target); break;}
        }catch (InputAccountTypeException e){
            System.out.println(e.getMessage());
            validateAccountType();
        }
    }

    private void createDepositAccount() {
        System.out.println(REQUEST_NAME);
        String name = getUserInput();
        Account account = new DepositAccount(DEPOSIT_ACCOUNT_TYPE, TEMP_VALUE, name, BigDecimal.ZERO, true);
        String accountNumber = bankSystem.createAccount(account);
        System.out.printf(DEPOSIT_ACCOUNT_CREATED, accountNumber);
    }

    private void createSavingAccount(BigDecimal target) {
        System.out.println(REQUEST_NAME);
        String name = getUserInput();
        Account account = new SavingAccount(SAVING_ACCOUNT_TYPE, TEMP_VALUE, name, BigDecimal.ZERO, target, true);
        String accountNumber = bankSystem.createAccount(account);
        System.out.printf(SAVING_ACCOUNT_CREATED, accountNumber);
    }

    private BigDecimal promptForTargetAmount() {
        System.out.println(PROMPT_TARGET_AMOUNT);
        return new BigDecimal(getUserInput());
    }
}