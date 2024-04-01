package view;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {
    public void printAccountInfo(List<String> combinedInfo) {
        combinedInfo.forEach(System.out::println);
    }

    public void setAccountInfo() {

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
