package bank.clerk;

import bank.BankSystem;
import exception.clerk.InputAccountNumberException;
import exception.system.NotFoundAccountException;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.util.Scanner;

@RequiredArgsConstructor
public class GetAccountInfoClerk implements Clerk {

    private static final String CLERK_REQUEST = "조회할 계좌번호를 입력해주세요.";

    private final BankSystem bankSystem;
    private final Scanner scanner = new Scanner(System.in);

    public void action() {
        System.out.println(CLERK_REQUEST);
        getAccountInfo();
    }

    public void getAccountInfo() {
        try{
            String accountNum = getUserInput();
            ValidationUtils.isValidAccountNumber(accountNum);
            String statusResult = bankSystem.getAccountInfo(accountNum);
            resultMessage(statusResult);
        }catch (InputAccountNumberException | NotFoundAccountException e){
            System.out.println(e.getMessage());
            getAccountInfo();
        }
    }
}

