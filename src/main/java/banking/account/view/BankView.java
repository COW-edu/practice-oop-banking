package banking.account.view;


import banking.account.controller.BankController;
import banking.account.domain.BasicAccount;
import banking.account.dto.AccountDTO;
import banking.account.exception.FormatException;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

import static banking.account.constant.ConstantMessage.*;

public class BankView {
    private static final Scanner sc = new Scanner(System.in);
    private final BankController bankController;

    public BankView(BankController bankController) {
        this.bankController = bankController;
    }


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
                case "6" :
                    System.exit(0);
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

        String inputStr = input();

        if (inputStr.length() != 8) {
            throw new FormatException("8자리로 입력해주세요,");
        }

        try {
            long number = Long.parseLong(inputStr);

            String formatNumber = df.format(number);
            return formatNumber;
        } catch (NumberFormatException e) {
            throw new FormatException("다시 시도해주세요.");// 입력값이 숫자로 변환될 수 없는 경우
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
