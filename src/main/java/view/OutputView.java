package view;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class OutputView {
    private static final String WITHDRAW_MESSAGE = "%s 계좌에서 %s원 출금이 완료되었습니다.%n";
    private static final String DEPOSIT_MESSAGE = "%s 계좌에 %s원 입금이 완료되었습니다.%n";
    private static final String CREATE_ACCOUNT_MESSAGE = "%s 님 계좌생성이 완료되었습니다.%n" ;
    private static final String TRANSFER_MESSAGE = "%s 계좌에서 $계좌로 %s원 송금이 완료되었습니다.%n";
    public static void withdrawEndMessage(String accountNumber, String amount) {
        System.out.printf(WITHDRAW_MESSAGE, accountNumber, amount);
    }

    public static void depositMessage(String accountNumber, String amount) {
        System.out.printf(DEPOSIT_MESSAGE, accountNumber, amount);
    }

    public static void createAccountEnd(String name) {
        System.out.printf(CREATE_ACCOUNT_MESSAGE,name);
    }

    public static void transferEnd(String fromAccount, String toAccount, String amount) {
        System.out.printf(TRANSFER_MESSAGE,fromAccount,toAccount,amount);
    }


    public void printAccountInfo(List<String> combinedInfo) {
        combinedInfo.forEach(System.out::println);
    }

    public void setAccountInfo(String accountType, String bankAccountNumber, String name, BigDecimal amount, BigInteger interestEstimated) {

    }

//나중에 상수처리
    public void setAccountInfo(String accountType, String bankAccountNumber, String name, BigDecimal amount, BigDecimal interestEstimated) {
        System.out.println("계좌종류: " + accountType);
        System.out.println("계좌번호: " + bankAccountNumber);
        System.out.println("소유자: " + name);
        System.out.println("잔액: " + amount);
        System.out.println("예상 금액: " + interestEstimated);
    }

    public void setAccountInfo(BigDecimal goalAmount) {
        System.out.println("목표 금액: " + goalAmount);
    }
}
