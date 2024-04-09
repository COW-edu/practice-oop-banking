package org.example.bank;



import org.example.account.Account;
import org.example.account.SavingAccount;
import org.example.exception.DepositException;
import org.example.exception.UnknownException;
import org.example.exception.WithdrawException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Bank {

    protected static Scanner sc = new Scanner(System.in);
    public static ArrayList<Account> accountList = new ArrayList<Account>();
    public int accountcnt =0;
    public String nameofBank = null;
    public static int howmanyBank = 0;

    public int accountLog = -1;

    public  Bank(){
        howmanyBank++;
    }

    public Bank(String nameofBank){
        this();
        this.nameofBank = nameofBank;
    }

    public void makeAccount(){
        System.out.println("------------");
        System.out.println("가입 서비스입니다. 원하시는 아이디를 입력하세요");
        String id = sc.nextLine();
        if(testID(id)){
            System.out.println("중복된 아이디입니다.");
            return;
        }

        System.out.println("원하시는 비밀번호를 입력하세요");
        String pw = sc.nextLine();
        accountList.add(accountcnt++, new Account(id, pw));
    }

    private boolean testID(String id){
        boolean exist = false;

        for(int i = 0; i<accountList.size(); i++){
            if(accountList.get(i).equals(id)){
                exist = true;
            }
        }
        return exist;
    }

    public void logout(){
        accountLog = -1;
        System.out.println("로그아웃 완료.");

    }

    public boolean login(String id, String pw){
        boolean ok = false;
        for(int i=0; i<accountList.size(); i++){
            if(accountList.get(i).SuccessLogin(id,pw)){
                ok = true;
                accountcnt=i;
                break;
            }
        }
        return ok;
    }

    public void displayinfo_Bank(){
        System.out.println("현재 사용하고 계신 은행 : "+ nameofBank);
        for(int i=0; i<accountList.size(); i++){
            accountList.get(i).display_info();
        }
    }

    public void letsuseMenu(){
        if(accountcnt != -1){
            accountList.get(accountcnt).showmenu();
        }
        else{
            System.out.println("에러발생");
        }
    }


    public void menu_Bank(){
            boolean keepgoing = true;

            while (keepgoing) {
                System.out.println("1.계정생성 2.계정삭제 3.로그인 4.로그아웃 5. 종료");
                String input = sc.nextLine();
                switch (input){
                    case "1" :
                        makeAccount();
                        displayinfo_Bank();
                        break;
                    case "2" :
                        //로그인 했는지 여부를 물어본다.
                        if(accountcnt != -1){
                            System.out.println("계정삭제를 하고 싶으시면 pw를 입력하세요! ");
                            String pw=sc.nextLine();
                            delete(pw);

                }
                        else{
                            System.out.println("로그인이 필요한 서비스입니다.");
                        }
                        break;
                    case "3":
                        System.out.println("로그인 서비스입니다");
                        System.out.println("id를 입력주세요 : ");
                        String id = sc.nextLine();
                        System.out.println("pw를 입력주세요 : ");
                        String pw = sc.nextLine();

                        if(login(id,pw)){
                            System.out.println("로그인 성공");
                            letsuseMenu();
                        }
                        else{
                            System.out.println("로그인 실패");
                        }
                        break;
                    case "4":
                        logout();
                        break;

            }

        }
    }

    public void delete(String pw){
        delete(accountList.get(accountcnt).id,pw);
    }

    public void delete(String id, String pw){
        boolean find_success = false;
        for(int i=0; i<accountList.size(); i++){
            if(accountList.get(i).SuccessLogin(id, pw)){
                accountcnt = i;
                find_success= true;
                break;

            }
        }

        if(find_success){
            accountList.remove(accountcnt);
            Account.howmanyaccout--;
            accountcnt= -1;


        }
    }


}



