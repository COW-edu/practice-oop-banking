package view;

import java.math.BigInteger;
import java.util.List;

public class OutputView {
    private static final String WITHDRAW_MESSAGE = "%s 계좌에서 %s원 출금이 완료되었습니다.%n";
    private static final String DEPOSIT_MESSAGE = "%s 계좌에 %s원 입금이 완료되었습니다.%n";
    private static final String CREATE_ACCOUNT_MESSAGE = "%s 님 계좌생성이 완료되었습니다.%n" ;
    private static final String TRANSFER_MESSAGE = "%s 계좌에서 %s계좌로 %s원 송금이 완료되었습니다.%n";
    private static final String EXPECTED_AMOUNT="예상 금액:";
private static final String DISABLE_ACCOUNT_MESSAGE="계좌가 비활성화 되었습니다.";

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

    public static void disableAccountEnd() {
        System.out.println(DISABLE_ACCOUNT_MESSAGE);
    }

    public void printAccountInfo(List<String> combinedInfo) {
        combinedInfo.forEach(System.out::println);
    }
//나중에 상수처리
    public void setAccountInfo(String accountInformation, BigInteger interestEstimated) {
        System.out.println(accountInformation);
        System.out.println(EXPECTED_AMOUNT+ interestEstimated);
    }
}