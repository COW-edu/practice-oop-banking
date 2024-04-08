package bank.clerk;

import bank.BankSystem;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
public class ChangeStatusClerk implements Clerk {

    private static final String CLERK_REQUEST = "계좌상태를 변경하려면 계좌번호를 입력해주세요";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        suspension();
    }

    private void suspension() {
        boolean completed = false;
        while (!completed) {
            try {
                String accountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(accountNum);
                String statusResult = bankSystem.changeStatus(accountNum);
                resultMessage(statusResult);
                completed = true;
            } catch (IllegalArgumentException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
