package bank.clerk;

import account.Account;
import account.AccountType;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankSystem;
import person.PersonalInfo;

import java.math.BigDecimal;
import java.util.Scanner;

public class RemittanceClerk implements Clerk{

    BankSystem bankSystem;
    Scanner sc = new Scanner(System.in);

    public RemittanceClerk(BankSystem bankSystem){
        this.bankSystem = bankSystem;
    }
    public RemittanceClerk(){

    }

    public void remittance(PersonalInfo personalInfo) {
        System.out.println("송금계좌, 수금계좌,금액을 작성해주세요");
    }
}
