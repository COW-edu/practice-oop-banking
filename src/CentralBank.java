import java.math.BigDecimal;
import java.util.*;

public class CentralBank
{
    private List<Account> accounts;
    private Map<String, InterestCalculator> Calcualateinterest;
    public CentralBank()
    {
        accounts = new ArrayList<>();
        Calcualateinterest = new HashMap<>();
        Calcualateinterest.put("N", new AccountInterestRate());
        Calcualateinterest.put("S", new SavingAccountInterestRate());
    }
    // 게좌 만들기
    public void createAccount(Account a)
    {
        if(a instanceof SavingAccount)
        {
            if(!((SavingAccount) a).compareCAGA(a))
            {
                accounts.add(a);
            }
            else
            {
                System.out.println("Your Gaol Amount is smaller than your Amount");
            }
        }
        else
        {
            accounts.add(a);
        }
    }
    // 전체 게좌 정보 출력
    public void printAllAccountsInfo()
    {
        for (Account account : accounts)
        {
            System.out.println(account.getAccountInfo());
        }
    }
    // 출금
    public void withdrawal(String accountNum, BigDecimal amount)
    {
        Account account = findAccountByNum(accountNum);
        if (account != null)
        {
            account.withdrawal(amount);
        }
        else {System.out.println("Account not found!");}
    }
    // 입금
    public void deposit(String accountNum, BigDecimal amount)
    {
        Account account = findAccountByNum(accountNum);
        if (account != null)
        {
            account.deposit(amount);
        }
        else
        {
            System.out.println("Unavailable Account");
        }
    }

    // 송금
    public void transfer(String senderAccountNum, String receiverAccountNum, BigDecimal amount) {

        Account sender = findAccountByNum(senderAccountNum);
        Account receiver = findAccountByNum(receiverAccountNum);
        if (sender != null && receiver != null)
        {
            sender.transfer(receiver, amount);
        } else
        {
            System.out.println("Sender or Receiver account not found!");
        }
    }

    // 계좌번호로 계좌 찾기
    private Account findAccountByNum(String accountNum)
    {
        for (Account account : accounts)
        {
            if (account.getAccountNum().equals(accountNum))
            {
                return account;
            }
        }
        return null;
    }

    // 이자를 계산하고 출력
    public void printAccountInfoNInterestRate(String accountNum)
    {
        for (Account account : accounts)
        {
            if(account.getAccountNum().equals(accountNum))
            {
                InterestCalculator calculator = Calcualateinterest.get(account.getAccountType());
                BigDecimal interest = calculator.getInterest(account.getAmount());
                System.out.println("Account Owner : " + account.getOwner() + ", Account Number: " + account.getAccountNum() + ", Interest : " + interest);
            }
        }
    }

    public void addInterest()
    {
        if(accounts != null)
        {
            for (Account account : accounts)
            {
                InterestCalculator calculator = Calcualateinterest.get(account.getAccountType());
                BigDecimal interestRate = calculator.getInterest(account.getAmount());
                BigDecimal interestAmount = account.getAmount().multiply(interestRate);

                account.setAmount(account.getAmount().add(interestAmount));
                System.out.println("Finished adding Interest " + interestAmount + " to " + account.getOwner());
            }
            System.out.println("Finished adding Interest!");
        }
        else
        {
            System.out.println("Accounts are not exist!");
        }
    }

}
