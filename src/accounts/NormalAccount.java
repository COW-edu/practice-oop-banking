package accounts;

import java.math.BigDecimal;

public class NormalAccount extends Account {
    public NormalAccount(String accountType, String accountNum, String owner, BigDecimal amount) {
        super(accountType, accountNum, owner, amount);
    }

    @Override
    public boolean withdraw(BigDecimal withdrawAmount) { //출금
        if(isValid(withdrawAmount)) {
            amount = amount.subtract(withdrawAmount);
            System.out.println("WithDraw Finish! your Amount : ₩" + this.amount);
            return true;
        } else {
            System.out.println("Failed WithDraw!");
            return false;
        }
    }
    @Override
    public boolean deposit(BigDecimal depositAmount) { //입금
        amount = amount.add(depositAmount);
        System.out.println("Deposite Finish! Your Amount : ₩" + amount);
        return true;
    }
    private boolean isValid(BigDecimal withdrawAmount) { // 예산 > 출금 금액인 경우
        return amount.compareTo(withdrawAmount) >= 0;
    }
}

