package bank;


import accountfile.SavingAccount;

import java.math.BigDecimal;


public class SavingBank extends Bank{
    public void withdraw(SavingAccount account) {
        BigDecimal goalAmount = account.getTargetAmount();
    }
}
