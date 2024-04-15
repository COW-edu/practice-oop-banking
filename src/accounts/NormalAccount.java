package accounts;

import java.math.BigDecimal;

public class NormalAccount extends Account {
    public NormalAccount(String accountType, String accountNum, String owner, BigDecimal amount) {
        super(accountType, accountNum, owner, amount);
    }

    @Override
    public void minusAmount(BigDecimal withdrawAmount) { //출금
            amount = amount.subtract(withdrawAmount);
            System.out.println("WithDraw Finish! your Amount : ₩" + this.amount);
    }

    @Override
    public void plusAmount(BigDecimal depositAmount) { //입금
        amount = amount.add(depositAmount);
        System.out.println("Deposite Finish! Your Amount : ₩" + amount);
    }
}