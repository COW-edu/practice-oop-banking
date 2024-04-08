package bank.clerk;

import bank.BankSystem;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class RemittanceClerk implements Clerk {

    private static final String CLERK_REQUEST = "출금계좌, 입금계좌, 금액을 차례로 작성해주세요";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        remittance();
    }

    private void remittance() {
        boolean completed = false;
        while (!completed) {
            try {
                String fromAccountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(fromAccountNum);
                String toAccountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(fromAccountNum);
                BigDecimal balance = ValidationUtils.createBalance(getUserInput());

                String balanceResult = bankSystem.remittance(fromAccountNum, toAccountNum, balance);
                resultMessage(balanceResult);
                completed = true;
            } catch (UnsupportedOperationException e){
                System.out.println(e.getMessage());
                completed = true;
            } catch (IllegalArgumentException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
