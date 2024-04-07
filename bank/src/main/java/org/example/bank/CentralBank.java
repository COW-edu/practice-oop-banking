package org.example.bank;


import org.example.account.Account;

import java.util.ArrayList;

public class CentralBank {


    //은행 계좌들을 관리하는 중앙은행 클래스
    private static CentralBank instance = new CentralBank();

    private static String BANK_NAME = "중앙은행";


    //이게 계좌들을 담은 리스트.
    private ArrayList<Account> accountList = new ArrayList<>();


    // getInstance 함수
    public static CentralBank getInstance(){
        if(instance == null)
            instance = new CentralBank();
        return instance;
    }

    // accountList getter/setter
    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
}
