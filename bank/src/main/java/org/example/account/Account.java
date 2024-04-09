package org.example.account;

import org.example.exception.DepositException;
import org.example.exception.WithdrawException;

import java.math.BigDecimal;


public class Account {
    public static int howmanyaccout= 0;
    public String id;
    public String pw;
    protected String category;
    protected String accountnum;
    protected BigDecimal balance;
    protected String owner;
    protected boolean isVaild;


    public Account(){
        howmanyaccout++;
    }
    public Account(String id, String pw){
        this();
        this.id = id;
        this.pw =pw;
    }
    public Account(String accNo, String owner, BigDecimal balance) {
        this();
        this.accountnum = accNo;
        this.owner = owner;
        this.balance = balance;
    }


    public boolean SuccessLogin(String id, String pw) {
        boolean ok = false; //2번
        if (this.id.equals(id) && this.pw.equals(pw)) {
            ok = true;
        }
        return ok;
    }

    public void display_info() {
        System.out.println("--------------------");
        System.out.println("전체 계정의 숫자 : " + Account.howmanyaccout);
        System.out.println("계좌 소유주 명  : " + owner);
        System.out.println("계좌 번호 : " + accountnum);
        System.out.println("계좌의 종류 : " + category);
        System.out.println("현재 사용하시는 Id는 : " + id);
        System.out.println("잔액 : " + balance);
        System.out.println("--------------------");
    }

    public void add(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void minus(BigDecimal amount){
        this.balance = this.balance.subtract(amount);

    }

    public void showmenu(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = null;
        boolean keepgoing = true;

        while(keepgoing){
            System.out.println("---------------");
            System.out.println(this.owner+"("+this.id+") 고객님 환영합니다." );
            System.out.println("필요하신 서비스에 해당되는 번호를 기입해주세요. ");
            System.out.println("1.입금 2.출금 ,3.종료");
            input = sc.nextLine();



            switch (input){
                case "1":
                    System.out.println("----입금메뉴-----");
                    display_info();
                    while(true){
                        try{
                            System.out.println("입금액을 입력하세요");
                            String amount = sc.nextLine();
                            BigDecimal howmuch = new BigDecimal(amount);
                            add(howmuch);
                            break;

                        } catch (NumberFormatException error){
                            System.out.println("유효한 숫자를 입력하셔야합니다.");
                        }
                    }
                    System.out.println("확인되었습니다.");
                    display_info();
                    break;

                case "2":
                    System.out.println("----출금메뉴-----");
                    display_info();
                    while(true){
                        try{
                            System.out.println("출금액을 입력하세요");
                            System.out.println("현재 잔액 : "+balance);
                            String amount = sc.nextLine();
                            BigDecimal howmuch = new BigDecimal(amount);
                            minus(howmuch);
                            break;

                        } catch (NumberFormatException error){
                            System.out.println("유효한 숫자를 입력하셔야합니다.");
                        }
                    }
                    System.out.println("확인되었습니다.");
                    display_info();
                    break;
                case "3" :
                    System.out.println("종료합니다. 이용해주셔서 감사합니다.");
                    keepgoing =false;
                    break;
                default:
                    System.out.println("다시 한번 입력해주세요.");


            }
        }


    }




    public String getAccountnum() {
        return accountnum;
    }

    public void setAccNo(String accNo) {
        this.accountnum = accNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isVaild(){
        return isVaild;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int size() {
        return howmanyaccout;
    }
}