package bank.clerk;

import bank.BankSystem;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class WithdrawClerk implements Clerk {

    private static final String CLERK_REQUEST = "[출금] 계좌, 금액을 작성해주세요";
    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        withdraw();
    }

    private void withdraw() {
        boolean completed = false;
        while (!completed) {
            try {
                String accountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(accountNum);
                BigDecimal balance = ValidationUtils.createBalance(getUserInput());

                String balanceResult = bankSystem.withdraw(accountNum, balance);
                resultMessage(balanceResult);
                completed = true;
            }catch (UnsupportedOperationException e){
                System.out.println(e.getMessage());
                completed = true;
            }catch (IllegalArgumentException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}