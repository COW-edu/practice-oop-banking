package org.example.account;

import java.math.BigDecimal;

public class AccountController {
    private Account account;
    private AccountView view;

    public AccountController(Account account, AccountView view){
        this.account=account;
        this.view = view;
    }

    public void addBalance(BigDecimal amount) {
        account.add(amount);
    }

    public void subtractBalance(BigDecimal amount) {
        account.minus(amount);
    }

   
}
