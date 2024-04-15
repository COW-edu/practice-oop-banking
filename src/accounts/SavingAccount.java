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
    public void minusAmount(BigDecimal withdrawAmount) { // 출금
        amount = amount.subtract(withdrawAmount);
        System.out.println("Withdraw Finish! Your Amount : ₩" + amount);
    }

    @Override
    public void plusAmount(BigDecimal depositAmount) { // 입금
        amount = amount.add(depositAmount);
        System.out.println("Deposit Finish! Your Amount : ₩" + amount);
    }

    @Override
    public boolean amountIsBiggerThanWithdrawAmount(BigDecimal withdrawAmount) { // 예산 > 출금 금액인 경우
        if (amountIsBiggerThanGoalAmount()) {
            return amount.compareTo(withdrawAmount) >= 0;
        }
        return false;
    }

    private boolean amountIsBiggerThanGoalAmount() { // 예산 > 목표 금액인 경우
        return amount.compareTo(goalAmount) >= 0;
    }
}
