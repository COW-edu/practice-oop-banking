package bank.clerk;

import bank.BankSystem;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class DepositClerk implements Clerk {

    private static final String CLERK_REQUEST = "[입금] 계좌, 금액을 작성해주세요";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        deposit();
    }

    private void deposit() {
        while (true) {
            try {
                String accountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(accountNum);
                BigDecimal balance = ValidationUtils.createBalance(getUserInput());
                String balanceResult = bankSystem.deposit(accountNum, balance);
                resultMessage(balanceResult);
                break;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
