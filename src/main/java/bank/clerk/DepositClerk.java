package bank.clerk;

import bank.BankSystem;
import exception.system.AccountStatusException;
import exception.clerk.InputAccountNumberException;
import exception.system.NotFoundAccountException;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;
import java.util.Scanner;

@RequiredArgsConstructor
public class DepositClerk implements Clerk{

    private static final String CLERK_REQUEST = "[입금] 계좌, 금액을 작성해주세요";

    private final BankSystem bankSystem;
    private final Scanner scanner = new Scanner(System.in);

    public void action() {
        System.out.println(CLERK_REQUEST);
        deposit();
    }

    public void deposit() {
        try {
            String accountNum = getUserInput(); ValidationUtils.isValidAccountNumber(accountNum);
            BigDecimal balance = ValidationUtils.createBalance(getUserInput());
            String balanceResult = bankSystem.deposit(accountNum, balance);
            resultMessage(balanceResult);

        }catch (NotFoundAccountException | InputAccountNumberException | NumberFormatException e) {
            System.out.println(e.getMessage());
            deposit();
        }catch (AccountStatusException e){
            System.out.println(e.getMessage());
        }
    }
}
