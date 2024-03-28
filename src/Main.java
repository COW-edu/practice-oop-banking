import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public int showMenu(Scanner s)
    {
        System.out.println("*********메뉴********");
        System.out.println("1. 계좌 생성");
        System.out.println("2. 인출");
        System.out.println("3. 입금");
        System.out.println("4. 송금");
        System.out.println("5. 이자보기");
        System.out.println("6. 전체 계좌 보기");
        System.out.println("7. 나가기");
        System.out.print("원하시는 작업을 선택해주세요 : ");
        return s.nextInt();
    }

    public Account getAccount(Scanner s)
    {
        String name;
        String type;
        String aNum;
        String amount;
        String goalAmount;

        System.out.print("성명을 입력해주세요 : ");
        name = s.next();
        System.out.println("예금계좌 : N, 적금게좌 : S");
        System.out.print("계좌 타입을 입력해주세요 : ");
        type = s.next();
        System.out.print("계좌번호를 입력해주세요 : ");
        aNum = s.next();
        System.out.print("예산를 입력해주세요 : ");
        amount = s.next();
        if(type.equals("S")) {goalAmount = s.next(); return new SavingAccount(type, aNum, name, new BigDecimal(amount), new BigDecimal(goalAmount));}
        else {return new Account(type, aNum, name, new BigDecimal(amount));}
    }

    public String getAccountNum(Scanner s)
    {
        System.out.println("계좌번호를 입력하세요");
        return  s.next();
    }



    public BigDecimal getAmount(Scanner s)
    {
        System.out.println("출금하실 금액을 입력하세요");
        return new BigDecimal(s.next());
    }

    public String getReceiverAccountNum(Scanner s)
    {
        System.out.println("송금하실 계좌번호를 입력하세요");
        return s.next();
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Main m = new Main();
        CentralBank c = new CentralBank();
        while(true)
        {
            int i = m.showMenu(s);
            switch(i)
            {
                case 1:
                    c.createAccount(m.getAccount(s));
                    break;
                case 2:
                    c.withdraw(m.getAccountNum(s), m.getAmount(s));
                    break;
                case 3:
                    c.deposit(m.getAccountNum(s), m.getAmount(s));
                    break;
                case 4:
                    c.transfer(m.getAccountNum(s), m.getReceiverAccountNum(s), m.getAmount(s));
                    break;
                case 5:
                    c.printAccountInfoNInterestRate(m.getAccountNum(s));
                    break;
                case 6:
                    c.printAllAccountsInfo();
                    break;
                case 7:
                    return;
            }
        }
    }
}
