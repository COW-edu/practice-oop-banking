package org.example.bank;
import org.example.account.Account;
import org.example.account.AccountManager;
import org.example.account.AccountView;
import org.example.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank  {
    protected static Scanner sc = new Scanner(System.in);

    public static ArrayList<Account> accountList = new ArrayList<Account>();
    static ArrayList<User> users = new ArrayList<>();
    public int accountcnt =0;
    public String nameofBank = null;
    public static int howmanyBank = 0;
    public int accountLog = -1;
    private BankController controller;


    public  Bank(){
        this.controller = new BankController(this);
        howmanyBank++;
    }

    public Bank(String nameofBank){
        this();
        this.nameofBank = nameofBank;
    }

    public void createUser() {
        System.out.println("------------------------------------");
        System.out.println("가입 서비스입니다. 원하시는 아이디를 입력하세요");
        String id = sc.nextLine();
        if(validateDuplicatedId(id)){
            System.out.println("중복된 아이디입니다.");
            return;
        }

        System.out.println("원하시는 비밀번호를 입력하세요");
        String pw = sc.nextLine();
        users.add(new User(id, pw));
        System.out.println("------------------");
        System.out.println("계정 생성을 시작합니다.");
        System.out.println("소유주 이름을 입력해주세요: ");
        String owner = sc.nextLine();
        System.out.println("계좌 번호를 입력해주세요: ");
        String accountNum = sc.nextLine();
        System.out.println("계좌의 종류를 입력해주세요: ");
        String category = sc.nextLine();
        System.out.println("초기 입금액을 입력해주세요: ");
        BigDecimal balance = new BigDecimal(sc.nextLine());

        Account newAccount = new Account(id,pw, owner, accountNum, category, balance);
        accountList.add(newAccount);
        System.out.println("계정이 성공적으로 생성되었습니다.");
    }


    public void displayinfo_Bank(){
        System.out.println("현재 사용하고 계신 은행 : "+ nameofBank);
        for(int i=0; i<accountList.size(); i++){
            AccountView accountView = new AccountView(accountList.get(i));
            accountView.display_info();
        }
    }

    public void LoginMenu(){
        if(accountcnt != -1){
            AccountView accountView = new AccountView(accountList.get(accountcnt));
            accountView.showmenu();
        }
        else{
            System.out.println("에러발생");
        }
    }


    public void menuBank(){
            boolean keepgoing = true;

            while (keepgoing) {
                System.out.println("1.계정생성 2.계정삭제 3.로그인 4.로그아웃 5.종료");
                String input = sc.nextLine();
                switch (input){
                    case "1" :
                        createUser();
                        displayinfo_Bank();
                        break;
                    case "2" :
                        //로그인 했는지 여부를 물어본다.
                        if(accountcnt != -1){
                            System.out.println("계정삭제를 하고 싶으시면 pw를 입력하세요. ");
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

                        if(controller.login(id,pw)){
                            System.out.println("로그인 성공");
                            LoginMenu();
                        }
                        else{
                            System.out.println("로그인 실패");
                        }
                        break;
                    case "4":
                        controller.logout();
                        break;
                    case "5":
                        System.out.println("프로그램을 완전히 종료합니다. 이용해주셔서 감사합니다.");
                        keepgoing =false;
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

    private boolean validateDuplicatedId(String id) {
        for(int i = 0; i<users.size(); i++){
            if(users.get(i).equals(id)){
                return true;
            }
        }
        return false;
    }
    public static Account findAccountByNumber(String accountNum) {
        for (Account account : accountList) {
            if (account.getAccountNum().equals(accountNum)) {
                return account;
            }
        }
        return null; // 해당 계좌 번호를 가진 계좌가 없을 경우
    }


}





