package bank.clerk;

import account.Account;
import account.AccountType;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankSystem;
import person.PersonalInfo;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositClerk implements Clerk{

    BankSystem bankSystem;
    Scanner sc = new Scanner(System.in);

    public DepositClerk(BankSystem bankSystem){
        this.bankSystem = bankSystem;
    }

    public DepositClerk(){

    }
    public void deposit(PersonalInfo personalInfo) {
        System.out.println("계좌, 금액을 작성해주세요");
        String accountNum = sc.nextLine();
        BigDecimal balance = new BigDecimal(sc.nextLine());
        System.out.println(bankSystem.deposit(accountNum, balance));


    }
}
