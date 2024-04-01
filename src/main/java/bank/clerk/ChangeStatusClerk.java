package bank.clerk;

import bank.BankSystem;
import exception.clerk.InputAccountNumberException;
import exception.system.NotFoundAccountException;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.util.Scanner;

@RequiredArgsConstructor
public class ChangeStatusClerk implements Clerk{

    private static final String CLERK_REQUEST = "계좌상태를 변경하려면 계좌번호를 입력해주세요";

    private final BankSystem bankSystem;
    private final Scanner scanner = new Scanner(System.in);

    public void action() {
        System.out.println(CLERK_REQUEST);
        suspension();
    }

    public void suspension() {
        try{
            String accountNum = getUserInput();
            ValidationUtils.isValidAccountNumber(accountNum);
            String statusResult = bankSystem.changeStatus(accountNum);
            resultMessage(statusResult);
        }catch (InputAccountNumberException | NotFoundAccountException e){
            System.out.println(e.getMessage());
            suspension();
        }
    }
}
