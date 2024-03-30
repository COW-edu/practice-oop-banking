package bank.clerk;

import account.Account;
import account.AccountType;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankSystem;
import person.PersonalInfo;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawClerk implements Clerk{

    BankSystem bankSystem;
    Scanner sc = new Scanner(System.in);

    public WithdrawClerk(BankSystem bankSystem){
        this.bankSystem = bankSystem;
    }

    public WithdrawClerk(){

    }


    public void withdraw(PersonalInfo personalInfo) {
        System.out.println("계좌, 금액을 작성해주세요");
    }


}
