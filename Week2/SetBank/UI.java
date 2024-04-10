package Week2.SetBank;

import Week2.SetBank.Bank;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UI extends Bank  {
    private Scanner scanner = new Scanner(System.in);

    // 1. 송금 2. 출금 3. 계좌찾기 이런식으로해서 해야할듯
    // 3누르면 계좌번호 입력하라고뜨고 그 계좌번호를 가지고있는 account찾아서 정보 출력

    public void userView() {
        boolean turnOff = false;
        String temp;
        BigDecimal money;
        int number;
        int temp_int;
        int temp2_int;

        while(true) {
            try {
                System.out.print("1. 계좌 등록\t2. 출금\t3. 입금\t4. 송금\t5. 계좌정보\t6. 이자금액\t 0. 종료 : ");
                number = scanner.nextInt();
                scanner.nextLine();

                if( isHaveAccount() == 0 ){     // 등록된 계좌가 없을 때 발생
                    if( number >= 2 && number <= 6) {
                        System.out.print("계좌가 없습니다. ");
                        throw new Exception();
                    }
                } else if ( isHaveAccount() == 1){      // 등록된 계좌가 한개일때 송금 못함
                    if( number == 4){
                        System.out.println("입력된 계좌가 1개 있습니다. ");
                        throw new Exception();
                    }
                }

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
                        } else {
                            System.out.println("다시 입력하세요");
                            continue;
                        }
                        break;
                    case 2: // 출금
                        System.out.print("계좌번호 입력 : ");
                        temp_int = scanner.nextInt();
                        scanner.nextLine();
                        if( !IsActivated(Integer.toString(temp_int))) {
                            System.out.println("비활성화 계좌입니다");
                            break;
                        }
                        System.out.print("출금할 금액 : ");
                        money = scanner.nextBigDecimal();
                        this.withdraw(Integer.toString(temp_int), money);
                        break;

                    case 3: // 입금
                        System.out.print("계좌번호 입력 : ");
                        temp_int = scanner.nextInt();
                        scanner.nextLine();
                        if( !IsActivated(Integer.toString(temp_int)) ) {
                            System.out.println("비활성화 계좌입니다");
                            break;
                        }
                        System.out.print("입금할 금액 : ");
                        money = scanner.nextBigDecimal();
                        this.deposit(Integer.toString(temp_int), money);
                        break;

                    case 4: // 송금
                        System.out.print("출금 계좌번호 입력 : ");
                        temp_int = scanner.nextInt();
                        scanner.nextLine();
                        if( !IsActivated(Integer.toString(temp_int))) {
                            System.out.println("비활성화 계좌입니다");
                            break;
                        }
                        System.out.print("입금 계좌번호 입력 : ");
                        temp2_int = scanner.nextInt();
                        scanner.nextLine();
                        if( !IsActivated(Integer.toString(temp2_int))) {
                            System.out.println("비활성화 계좌입니다");
                            break;
                        }
                        System.out.print("보낼 금액 : ");
                        money = scanner.nextBigDecimal();
                        this.remittance(Integer.toString(temp_int), Integer.toString(temp2_int), money);
                        break;
                    case 5: // 계좌정보
                        System.out.print("계좌번호 입력 : ");
                        temp_int = scanner.nextInt();
                        scanner.nextLine();
                        this.getAccountInfo(Integer.toString(temp_int));
                        break;
                    case 6: // 이자
                        System.out.print("계좌번호 입력 : ");
                        temp_int = scanner.nextInt();
                        scanner.nextLine();
                        this.getInterest(Integer.toString(temp_int));
                        break;
                    default:
                        System.out.println("다시 입력하시오");
                }
                if (turnOff) { // 0 입력시 turnOff true로
                    System.out.println("종료합니다");
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("다시 입력하세요");
                scanner.nextLine();
            }
            catch(Exception e){
                System.out.println("다시 입력하세요");
            }
        }
        scanner.close();
    }
}
