package bank.clerk;

import account.Account;
import account.AccountType;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankSystem;
import person.PersonalInfo;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateAccountClerk implements Clerk{

    BankSystem bankSystem;
    Scanner sc = new Scanner(System.in);

    public CreateAccountClerk(BankSystem bankSystem){
        this.bankSystem = bankSystem;
    }
    public CreateAccountClerk(){

    }

    public void validateAccountType(PersonalInfo personalInfo) {
        System.out.println("개설하실 계좌 유형을 작성해주세요 ex) 예금계좌, 적금계좌");
        String accountType = sc.nextLine();

        switch (accountType) {
            case "예금계좌": createAccount(personalInfo, AccountType.DEPOSIT);break;
            case "적금계좌": createAccount(personalInfo, AccountType.SAVING);break;
            default: System.out.println("지원하지 않는 계좌 유형입니다.");
            break;}}

    private void createAccount(PersonalInfo personalInfo, AccountType type) {
        String resultMessage = "";
        switch (type) {
            case DEPOSIT:resultMessage = createDepositAccount(personalInfo); break;
            case SAVING:
                System.out.println("목표금액을 설정해주세요");
                BigDecimal target = new BigDecimal(sc.nextLine());
                resultMessage = createSavingAccount(personalInfo, target);
                break;} System.out.println("계좌가 생성되었습니다. 계좌번호는 [" + resultMessage + "] 입니다.");
    }

    public String createDepositAccount(PersonalInfo personalInfo) {
        Account account = new DepositAccount("N", "temp", personalInfo.getName(), new BigDecimal("0"), true);
        return bankSystem.createAccount(account);
    }

    private String createSavingAccount(PersonalInfo personalInfo, BigDecimal target) {
        Account account = new SavingAccount("S", "temp", personalInfo.getName(), new BigDecimal("0"), new BigDecimal("0"), true);
        return bankSystem.createAccount(account);
    }

}
