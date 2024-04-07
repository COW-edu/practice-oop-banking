package accounts;

import java.math.BigDecimal;

public class SavingAccount extends Account {
    private BigDecimal goalAmount;

    public SavingAccount(String accountType, String accountNum, String owner, BigDecimal amount, BigDecimal goalAmount) {
        super(accountType, accountNum, owner, amount);
        this.goalAmount = goalAmount;
    }

    @Override
    public String getAccountInfo() { // 계좌 정보 출력
        return super.getAccountInfo() + "\n" +
                "Goal Asset : ₩" + goalAmount;
    }

    @Override
    public boolean withdraw(BigDecimal withdrawAmount) { // 출금
        if(isValid(withdrawAmount)) {
            if(isBiggerThanGoal()) {
                amount = amount.subtract(withdrawAmount);
                System.out.println("WithDraw Finish! your Amount : ₩" + amount); // withdraw 성공
                return true;
            } else {
                System.out.println("WithDraw Failed your Amount : ₩" + amount
                        + " and your GoalAmount : ₩" + goalAmount); // 예산 < 목표금액
                return false;
            }
        } else {
            System.out.println("WithDraw Failed your Amount : ₩" + amount); // 예산 < 출금 금액
            return false;
        }
    }

    private boolean isValid(BigDecimal withdrawAmount) { // 예산 > 출금 금액인 경우
        return amount.compareTo(withdrawAmount) >= 0;
    }

    private boolean isBiggerThanGoal() { // 예산 > 목표금액인 경우
        return amount.compareTo(goalAmount) >= 0;
    }

    @Override
    public boolean deposit(BigDecimal depositAmount) { // 입금
        amount = amount.add(depositAmount);
        System.out.println("Deposite Finish! Your Amount : ₩" + amount);
        return true;
    }
}
