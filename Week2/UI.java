package Week2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Scanner;


public class UI extends Bank{
    private Scanner scanner = new Scanner(System.in);

    public void test(){
        System.out.println("UI 잘 만들어짐");
    }


    // 1. 송금 2. 출금 3. 계좌찾기 이런식으로해서 해야할듯
    // 3누르면 계좌번호 입력하라고뜨고 그 계좌번호를 가지고있는 account찾아서 정보 출력

    public void userView() {
        boolean turnOff = false;
        String temp;
        String temp2;
        BigDecimal money;
        int number;

        while(true) {
            System.out.print("1. 계좌 등록\t2. 출금\t3. 입금\t4. 송금\t5. 계좌정보\t 0. 종료 : ");
            number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 0:
                    turnOff = true;
                    break;
                case 1: // 계좌등록
                    System.out.print("계좌종류(N or S) : ");
                    temp = scanner.next();
                    scanner.nextLine();

                    if (temp.equals("S")) {
                        this.createSavingAccount();
                    } else if (temp.equals("N")) {
                        this.createBasicAccount();
                    }
                    break;
                case 2: // 출금
                    System.out.print("계좌번호 입력 : ");
                    temp = scanner.nextLine();
                    System.out.print("출금할 금액 : ");
                    money = scanner.nextBigDecimal();
                    this.withdraw(temp, money);
                    break;
                case 3: // 입금
                    System.out.print("계좌번호 입력 : ");
                    temp = scanner.nextLine();
                    System.out.print("입금할 금액 : ");
                    money = scanner.nextBigDecimal();
                    this.deposit(temp, money);
                    break;
                case 4: // 송금
                    System.out.print("보낼 계좌번호 입력 : ");
                    temp = scanner.nextLine();
                    System.out.print("받을 계좌번호 입력 : ");
                    temp2 = scanner.nextLine();
                    System.out.print("보낼 금액 : ");
                    money = scanner.nextBigDecimal();
                    this.remittance(temp,temp2,money);
                    break;
                case 5: // 계좌정보
                    System.out.print("계좌번호 입력 : ");
                    temp = scanner.nextLine();
                    this.getAccountInfo(temp);
                    break;
                default:
                    System.out.println("다시 입력하시오");
            }
            if( turnOff ){ // 0 입력시 turnOff true로
                break;
            }
        }
    }
}
