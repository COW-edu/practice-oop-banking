package bank;

import account.Account;
import account.EAccount;
import utility.Dialog;

import java.util.ArrayList;
import java.util.HashMap;

public class CentralBank {


    ArrayList<Account> accountList;
    HashMap<EAccount, InterestCalculator> interestCalculatorTable;

//    HashMap<Integer, Bank> bankTable;

    public CentralBank(){
        accountList = new ArrayList<>();
        interestCalculatorTable = new HashMap<>();
        interestCalculatorTable.put(EAccount.N, new NormalInterestCalculator());
        interestCalculatorTable.put(EAccount.S, new SaveInterestCalculator());
    }
    public boolean registerAccount(Account newAccount){
        for (Account account : accountList){
            if(account.getAccountNum().equals(newAccount.getAccountNum())) {
                Dialog.systemMsg("등록실패!! 중복된 계좌번호입니다.");
                return false;
            }
        }
        accountList.add(newAccount);
        return true;
    }

    public boolean checkVerifyNum(String accountNum){
        // 구현 필요
        return true;
    }
    public Account getAccount(String accountNum){
        for(Account account : accountList){
            if(account.getAccountNum().equals(accountNum)) {
                Dialog.systemMsg("등록실패!! 중복된 계좌번호입니다.");
                return account;
            }
        }
        return null;
    }

}
