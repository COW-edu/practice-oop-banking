package bank.clerk;

import bank.BankSystem;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
public class GetAccountInfoClerk implements Clerk {

    private static final String CLERK_REQUEST = "조회할 계좌번호를 입력해주세요.";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        getAccountInfo();
    }

    private void getAccountInfo() {
        boolean completed = false;
        while (!completed) {
            try {
                String accountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(accountNum);
                String statusResult = bankSystem.getAccountInfo(accountNum);
                resultMessage(statusResult);
                completed = true;
            } catch (IllegalArgumentException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

