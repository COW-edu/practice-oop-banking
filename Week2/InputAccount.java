package Week2;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputAccount {
    private Scanner s = new Scanner(System.in);

//    public AccountType inputAccountType(){
//        System.out.print("계좌종류(N or S) : ");
//
//        String temp = s.next();
//        s.nextLine();
//
//        if ( temp.equals("S")){
//            return AccountType.SAVING_ACCOUNT;
//        } else {
//            return AccountType.NORMAL_ACCOUNT;
//        }
//
//    }

    public String inputAccountNumber(){
        System.out.print("계좌번호 : ");

        String temp = s.nextLine();

        return temp;
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
