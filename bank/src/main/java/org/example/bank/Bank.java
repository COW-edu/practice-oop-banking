package org.example.bank;


import org.example.account.Account;
import org.example.account.SavingAccount;
import org.example.exception.DepositException;
import org.example.exception.UnknownException;
import org.example.exception.WithdrawException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Bank {
    protected static Scanner scanner = new Scanner(System.in);
    protected static int seq = 0;
    public static DecimalFormat df = new DecimalFormat("#,###");

    ///이자계산을 위한 해시맵


    private HashMap<String, InterestCalculator> interestCalculators = new HashMap<>();

    public Bank(){
        //이자계산기 11
        interestCalculators.put("Normal",  new BasicInterestCalculator());
        interestCalculators.put("Saving", new SavingInterestCalculator());
    }
    //입금 메서드
    public void deposit() throws DepositException, UnknownException{
        //1. 계좌번호를 입력 후 맞는지 확인
        String accountNum = askInput("\n출금하려는 계좌의 번호를 입력하세요 : ","");


    }


    //출금 메서드
    public void withdraw() throws WithdrawException, UnknownException {

        //1. 계좌번호를 입력하고,맞는지 확인.

        Account account = null;
        while(true) {
            String accountNum = askInput("\n 출금하려는 계좌의 번호를 입력하세요 : ", "");

            try {
                account = findAccount(accountNum);


                if(account.getCategory().equals("Saving")) {
                    //savingAccont은 다른 방식의 출금을 한다.
                    new SavingBank().withdraw((SavingAccount) account);
                }

                //목적 달성하면 break.
                break;


            } catch(WithdrawException err) {
                System.out.println(err.getMessage());
                return;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                break;
            }

        }

        // 출금처리 (normal account)
        while(true){
            try{
                //askinput 함수에 명시적으로 숫자타입이라고 알려주는거임
                BigDecimal amount = askInput("\n출금할 금액을 입력하세요.", BigDecimal.ZERO);
                BigDecimal result;

                //이자 계산 Key(string) ,value(interestcalulator)
                BigDecimal interest = interestCalculators.get(account.getCategory()).getInterest(account.getBalance());
                result = account.withdraw(amount);
                //나머지 금액은 어디로가지?
                System.out.printf("\n출금액 %s원과 이자 %s원이 정상적으로 출금되었습니다.\n", df.format(result), df.format(interest));
                break;
            }catch(WithdrawException we) {
                throw we;
            }catch (Exception e){
                throw new WithdrawException(e.getMessage());
            }
        }
    }



    //계좌 finding
    public Account findAccount(String accNo)  {
        // 계좌리스트에서 찾아서 반환하는 메서드 구현

        //finding 용 account
        Account account = null;



        for (Account acc : CentralBank.getInstance().getAccountList()) {
            //계좌가 vaild하고 계좌번호가 같다면 일단 불러
            if (acc.getaccountNum().equals(accNo) && acc.isVaild()) {
                account = acc;
            }
        }
        // if(account == null) throw new UnknownException("해당 계좌가 존재하지 않습니다.");
        return account;
    }











    //funcitons
    public Account createAccount() throws InputMismatchException {
        // 계좌 생성하는 메서드 구현
        try {
            // 계좌번호
            // 계좌번호는 "0002"+증가한 seq 포맷을 가진 번호입니다.
            String accNo = String.format(new DecimalFormat("0000").format(++seq));
            String owner = askInput("\n소유주명을 입력해주세요.", "");
            BigDecimal amount = askInput("\n최초 입금액을 입력해주세요.", BigDecimal.ZERO);
            Account account = new Account(accNo, owner, amount);
            CentralBank.getInstance().getAccountList().add(account);
            System.out.printf("\n%s님 계좌가 발급되었습니다.\n", owner);
            return account;
        }catch (InputMismatchException ime){
            if(seq > 0) seq--;
            throw ime;
        }catch (Exception e){
            throw e;
        }
    }


    //input 받는 메서드 구현

    public <T> T askInput(String msg, T obj){

        // 모든 것을 아우르는 object type의 변수를 생성.
        Object input;


        while(true) {
            try {
                System.out.println(msg);

                //BigDecimal type을 입력한다면,
                if(obj instanceof BigDecimal){
                    input = scanner.nextBigDecimal();
                }else{
                    input = scanner.next();
                }
            } catch (InputMismatchException e) {

                System.out.println(obj.getClass().toString() +" 형식으로 입력해주세요.");

                scanner.next();

                /*복문에서 만약 askinput()을 여러번 실행해야할때 만약 반복문 내에서
                // catch구문이 발동될때 프로그램이 종료되는 것이
                 아닌 다음 것으로 proceed하기 위한 */
                continue;
            }

            //input을 decimal로 타입 캐스팅한다.
            //scale() 함수는 소수점오른쪽의 자릿수를 알려준다. ex) 0.27 일 경우 > 2
            //signum() 함수는 0,-1, 1 셋 중 하나를 반환하며 음수인지 양수인지 0인지를 파악하는 함수이다.


            return (T)input;
        }
    }
}
