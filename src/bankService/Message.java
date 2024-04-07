package bankService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Message {
    private static Scanner scanner = new Scanner(System.in);
    private CentralBank centralBank = new CentralBank();
    public boolean askAction(){
        System.out.println("***********************");
        System.out.println("어떻게 도와드릴까요?");
        System.out.println("1. 계좌 생성");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 송금");
        System.out.println("5. 계좌 정보 확인");
        System.out.println("6. 종료");

        return doAction(scanner.nextInt());
    }

    private boolean doAction(int actionNumber){
        switch (actionNumber){
            case 1:
                makeAccount();
                return true;
            case 2:
                doDeposite();
                return true;
            case 3:
                doWithdraw();
                return true;
            case 4:
                doTransfer();
                return true;
            case 5:
                checkAmount();
                return true;
            case 6:
        }
        return false;
    }

    private void makeAccount() {
        System.out.println("***********************");
        System.out.println("새 계좌 정보를 입력해주세요");
        System.out.println("1. 이름");
        String name = scanner.next();
        System.out.println("2. 계좌번호");
        String accountNum = scanner.next();
        System.out.println("3. 계좌 타입 ( Normal, Saving )");
        String accountType = scanner.next();
        System.out.println("4. 자산");
        String strAmount = scanner.next();
        BigDecimal amount = new BigDecimal(strAmount);

        if(accountType.equals("Normal")) { // 일반 계좌
            centralBank.createNormalAccount(name, accountNum, accountType, amount);
        } else if(accountType.equals("Saving")) { // 적금 계좌 (GoalAmount 필요)
            System.out.println("5. 목표 자산");
            String strGoalAmount = scanner.next();
            BigDecimal goalAmount = new BigDecimal(strGoalAmount);
            centralBank.createSavingAccount(name, accountNum, accountType, amount, goalAmount);
        } else {
            System.out.println("Wrong Account Type!");
        }
    }

    private void doDeposite() {
        System.out.println("***********************");
        System.out.println("입금할 계좌 번호를 입력해주세요");
        System.out.println("1. 계좌번호");
        String accountNum = scanner.next();
        System.out.println("2. 금액");
        String strAmount = scanner.next();
        BigDecimal depositeAmount = new BigDecimal(strAmount);

        centralBank.deposite(accountNum, depositeAmount);
    }

    private void doWithdraw() {
        System.out.println("***********************");
        System.out.println("출금할 계좌 번호를 입력해주세요");
        System.out.println("1. 계좌번호");
        String accountNum = scanner.next();
        System.out.println("2. 금액");
        String strAmount = scanner.next();
        BigDecimal withdrawAmount = new BigDecimal(strAmount);

        centralBank.withDraw(accountNum, withdrawAmount);
    }

    private void doTransfer() {
        System.out.println("***********************");
        System.out.println("인출, 송금 계좌 번호를 입력해주세요");
        System.out.println("1. 인출계좌번호");
        String senderAccountNum = scanner.next();
        System.out.println("2. 송금계좌번호");
        String receiverAccountNum = scanner.next();
        System.out.println("3. 금액");
        String strAmount = scanner.next();
        BigDecimal transferAmount = new BigDecimal(strAmount);

        centralBank.transfer(senderAccountNum, receiverAccountNum, transferAmount);
    }

    private void checkAmount() {
        System.out.println("***********************");
        System.out.println("확인을 원하는 계좌 번호를 입력해주세요");
        System.out.println("1. 계좌번호");
        String accountNum = scanner.next();

        centralBank.printAccountInfo(accountNum);
    }
}
