package org.example;

import org.example.account.Account;
import org.example.bank.Bank;

import java.math.BigDecimal;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("국민은행");
        bank.menuBank();
        }
}
