import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    Pattern pattern = Pattern.compile("\\d{6}-\\d{2}-\\d{6}");
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
        BigDecimal amount;
        BigDecimal goalAmount;

        System.out.print("성명을 입력해주세요 : ");
        name = s.next();

        type = getAccountType(s);
        aNum = getAccountNum(s);
        amount = getAmount(s);

        if(type.equals("S"))
        {
            goalAmount = getGoalAmount(s, amount);
            return new SavingAccount(type, aNum, name, amount, goalAmount);
        }
        else {return new Account(type, aNum, name, amount);}

    }

    public String getAccountType(Scanner s)
    {
        System.out.println("예금계좌 : N, 적금게좌 : S");
        System.out.print("계좌 타입을 입력해주세요 : ");
        String at = s.next();
        while(!at.equals("N") && !at.equals("S"))
        {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("계좌타입을 다시 입력해주세요 : ");
            at = s.next();
        }
        return at;
    }

    public boolean isNumber(String s)
    {
        try {Double.parseDouble(s);}
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    public String getAccountNum(Scanner s)
    {
        System.out.println("계좌번호를 입력하세요");
        String an =  s.next();
        Matcher m = pattern.matcher(an);
        while(!m.matches())
        {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("계좌번호를 다시 입력해주세요 : ");
            an = s.next();
            m = pattern.matcher(an);
        }
        return an;
    }
    public BigDecimal getAmount(Scanner s)
    {
        System.out.println("금액을 입력하세요");
        String am =  s.next();
        while(!isNumber(am))
        {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("예산을 다시 입력해주세요 : ");
            am = s.next();
        }
        return new BigDecimal(am);
    }
    public BigDecimal getGoalAmount(Scanner s, BigDecimal current)
    {
        System.out.println("적금 목표 금액을 입력하세요");
        String gm =  s.next();
        while(!isNumber(gm) || current.compareTo(new BigDecimal(gm)) > 0)
        {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("목표 금액을 다시 입력해주세요 : ");
            gm = s.next();
        }
        return new BigDecimal(gm);
    }

    public String getReceiverAccountNum(Scanner s)
    {
        System.out.println("송금하실 계좌번호를 입력하세요");
        String an =  s.next();
        Matcher m = pattern.matcher(an);
        while(!m.matches())
        {
            System.out.println("잘못된 입력값입니다.");
            System.out.print("계좌번호를 다시 입력해주세요 : ");
            an = s.next();
            m = pattern.matcher(an);
        }
        return an;
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
