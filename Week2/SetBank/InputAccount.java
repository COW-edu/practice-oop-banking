package Week2.SetBank;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputAccount {
    private Scanner s = new Scanner(System.in);
    public String inputAccountNumber(){
        System.out.print("계좌번호 : ");

        int temp = s.nextInt();
        s.nextLine();

        return String.valueOf(temp);
    }

    public String inputOwner(){
        System.out.print("소유자명 : ");

        String temp = s.nextLine();

        return temp;
    }

    public BigDecimal inputBalance(){
        System.out.print("잔고 : ");

        BigDecimal b = s.nextBigDecimal();

        return b;
    }

    public boolean inputIsActivated(){
        System.out.print("활성 여부(Y/N) : ");

        String temp = s.next();
        s.nextLine();

        if( temp.equals("Y")){
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal inputTargetAmount(){
        System.out.print("목표금액 : ");

        BigDecimal b = s.nextBigDecimal();
        s.nextLine();

        return b;
    }


}
