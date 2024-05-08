package org.example.account;

import org.example.Exception.InSufficientBalanceException;

import java.math.BigDecimal;
import org.example.bank.Bank;

import static org.example.bank.Bank.findAccountByNumber;

public class AccountView {
    private Account account;
    private AccountController controller;
    private  AccountManager manager;

    public AccountView(Account account) {
        this.account =account;


    }

    public void display_info() {
        System.out.println("--------------------");
        System.out.println("전체 계정의 숫자 : " + account.howmanyaccout);
        System.out.println("계좌 소유주 명  : " + account.owner);
        System.out.println("계좌 번호 : " + account.accountNum);
        System.out.println("계좌의 종류 : " + account.category);
        System.out.println("현재 사용하시는 Id는 : " + account.id);
        System.out.println("잔액 : " + account.balance);
        System.out.println("--------------------");
    }
    public void showmenu() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = null;
        boolean keepgoing = true;

        while (keepgoing) {
            System.out.println("---------------");
            System.out.println(account.getOwner() + "(" + account.getId() + ") 고객님 환영합니다.");
            System.out.println("필요하신 서비스에 해당되는 번호를 기입해주세요. ");
            System.out.println("1.입금 2.출금 3.송금 4.종료");
            input = sc.nextLine();


            switch (input) {
                case "1":
                    System.out.println("----입금메뉴-----");
                    display_info();
                    while (true) {
                        try {
                            System.out.println("입금액을 입력하세요");
                            String amount = sc.nextLine();
                            BigDecimal howmuch = new BigDecimal(amount);
                            account.add(howmuch);
                            break;

                        } catch (NumberFormatException error) {
                            System.out.println("유효한 숫자를 입력하셔야합니다.");
                        }
                    }
                    System.out.println("확인되었습니다.");
                    display_info();
                    break;

                case "2":
                    System.out.println("----출금메뉴-----");
                    display_info();
                    while (true) {
                        try {
                            System.out.println("출금액을 입력하세요");
                            System.out.println("현재 잔액 : " + account.getBalance());
                            String amount = sc.nextLine();
                            BigDecimal howmuch = new BigDecimal(amount);
                            if(account.balance.compareTo(howmuch)>=0){
                               account.minus(howmuch);
                                System.out.println("확인되었습니다.");
                                display_info();
                            }
                            else{
                                throw new InSufficientBalanceException("잔액이 부족합니다. 올바른 출금액을 입력하세요.");
                            }

                        } catch (NumberFormatException error ) {
                            System.out.println("유효한 숫자를 입력하셔야합니다.");
                        }
                        catch(InSufficientBalanceException e){
                            System.out.println("잔액이 부족합니다. 올바른 출금액을 입력하세요. ");
                            System.out.println("초기화면으로 돌아갑니다.");
                            break;
                        }

                    }

                    break;
                case "3":
                    System.out.println("----송금메뉴-----");
                    display_info();
                    while (true) {
                        try {
                            System.out.println("송금할 금액을 입력하세요");
                            String amount = sc.nextLine();
                            BigDecimal howmuch = new BigDecimal(amount);

                            System.out.println("송금 받을 계좌 번호를 입력하세요");
                            String accountNum = sc.nextLine();

                            // 송금 받을 계좌 찾기 (이 예시에서는 단순화를 위해 manager에서 직접 호출)
                            Account recipientAccount = findAccountByNumber(accountNum);

                            if (recipientAccount == null) {
                                System.out.println("송금 받을 유효한 계좌를 찾을 수 없습니다.");
                                break; // 또는 계속 진행하도록 로직을 수정할 수 있습니다.
                            }

                            if(account.getBalance().compareTo(howmuch) >= 0) {
                                // 송금 로직
                                account.minus(howmuch); // 송금자 계좌에서 금액 차감
                                recipientAccount.add(howmuch); // 수신자 계좌에 금액 추가
                                System.out.println("송금이 완료되었습니다.");
                                display_info();
                                break;
                            } else {
                                throw new InSufficientBalanceException("잔액이 부족합니다. 올바른 금액을 입력하세요.");
                            }
                        } catch (NumberFormatException error) {
                            System.out.println("유효한 숫자를 입력하셔야합니다.");
                        } catch(InSufficientBalanceException e) {
                            System.out.println(e.getMessage());
                            break; // 또는 사용자가 재시도할 수 있도록 로직을 수정할 수 있습니다.
                        }
                    }
                    break;
                case "4":
                    System.out.println("종료합니다. 이용해주셔서 감사합니다.");
                    keepgoing = false;
                    break;
                default:
                    System.out.println("다시 한번 입력해주세요.");


            }
        }



    }
}
