package bank.clerk;

import bank.BankSystem;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;


@RequiredArgsConstructor
public class ChangeStatusClerk implements Clerk {

    private static final String CLERK_REQUEST = "계좌상태를 변경하려면 계좌번호를 입력해주세요";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        suspension();
    }

    private void suspension() {
        while (true) {
            try {
                String accountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(accountNum);
                String statusResult = bankSystem.changeStatus(accountNum);
                resultMessage(statusResult);
                break;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
