package org.example;

import org.example.account.Account;
import org.example.bank.Bank;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //1. 어떤 행동을 취할 것인가요? 1.입금 2.송금
        //2. 선택
        //3. 서비스를 제공하잖아.
        //4. 입금 후 내 계좌잔액.
        Bank bank = new Bank("국민");
        bank.menu_Bank();





        }



}
