package banking.account.view;


import banking.account.controller.BankController;
import banking.account.domain.BasicAccount;
import banking.account.dto.AccountDTO;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

import static banking.account.constant.ConstantMessage.*;

public class BankView {
    private static final Scanner sc = new Scanner(System.in);
    private BankController bankController = BankController.getInstance();


    public void startMenu () {

        while(true) {
            System.out.printf(CHOICE + "\n" + MENU + "\n");
            String switchNum = input();

            switch(switchNum) {
                case "1":
                    accountInput();
                    break;
                case "2":
                    // 입금
                    deposit();
                    break;
                case "3":
                    // 출금
                    withdraw();
                    break;
                case "4":
                    // 송금
                    trasfer();
                    break;
                case "5":
                    // 계좌 조회
                    findAccount();
                    break;
                default:
                    break;
            }
        }
    }

    private void trasfer() {
        System.out.println(DEPOSIT + ACCOUNT_NUMBER );
        String depositAccountNum = getFormat();

        System.out.println(DEPOSIT + ACCOUNT_NUMBER );
        String withdrawAccountNum = getFormat();

        System.out.println(TRANSFER + BALANCE );
        BigDecimal transferAmount = new BigDecimal(input());

        bankController.transfer(depositAccountNum,withdrawAccountNum,transferAmount);

    }

    private void withdraw() {
        System.out.println(WITHDRAW + ACCOUNT_NUMBER);
        String accountNum = getFormat();

        System.out.println(WITHDRAW + BALANCE );
        BigDecimal depositAmount = new BigDecimal(input());
        bankController.withdraw(accountNum,depositAmount);
    }

    private void deposit() {
        System.out.println(DEPOSIT + ACCOUNT_NUMBER );
        String accountNum = getFormat();

        System.out.println(DEPOSIT + BALANCE );
        BigDecimal depositAmount = new BigDecimal(input());
        bankController.deposit(accountNum,depositAmount);
    }

    private void findAccount() {
        System.out.println(ACCOUNT_NUMBER);
        String accountNum = getFormat();
        System.out.println(accountNum);
        BasicAccount account = bankController.findAccount(accountNum);
        System.out.println(ACCOUNT_INFO);
        System.out.println(account.getAccountInfo());
    }

    private String getFormat() {
        DecimalFormat df = new DecimalFormat("00000000");

        // input()으로부터 입력받은 문자열 (계좌 번호 등)
        String inputStr = input();

        try {
            // 문자열을 long 타입으로 변환
            long number = Long.parseLong(inputStr);

            // 숫자를 형식화된 문자열로 변환
            String formatNumber = df.format(number);
            return formatNumber;
        } catch (NumberFormatException e) {
            // 입력값이 숫자로 변환될 수 없는 경우
            System.out.println(ERROR_INPUT_TYPE);
            return null; // 또는 적절한 기본값 또는 오류 처리
        }
    }

    private void accountInput() {
        System.out.println(ACCOUNT_TYPE);
        int typeNum = Integer.parseInt(input());
        
        System.out.println(ACCOUNT_NUMBER);
        String accountNumber = getFormat();

        System.out.println(ACCOUNT_OWNER);
        String owner = input();

        System.out.println(BALANCE);
        String money = input();

        AccountDTO accountDTO;

        if(typeNum == 2) {
            System.out.println(TARGET + BALANCE);
            String targetAmount = input();
            accountDTO = new AccountDTO(typeNum,accountNumber, owner, money, targetAmount);
        } else {
            accountDTO = new AccountDTO(typeNum,accountNumber, owner, money);
        }

        bankController.createAccount(accountDTO);
    }

    private static String input() {
        return sc.nextLine();
    }
}
