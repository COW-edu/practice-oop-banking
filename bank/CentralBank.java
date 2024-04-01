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
        if(!checkVerifyNum(newAccount.getAccountNum())) {
            Dialog.systemMsg("등록실패!! 유효하지 않은 계좌번호입니다.");
            return false;
        }
        for (Account account : accountList){
            if(account.getAccountNum().equals(newAccount.getAccountNum())) {
                Dialog.systemMsg("등록실패!! 중복된 계좌번호입니다.");
                return false;
            }
        }
        accountList.add(newAccount);
        return true;
    }

    public boolean checkVerifyNum(String accountNum) {
        int[] weights = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4};

        int sum = 0;
        for (int i = 0; i < accountNum.length(); i++) {
            char digit = accountNum.charAt(i);
            if (Character.isDigit(digit)) {
                int num = Character.getNumericValue(digit);
                sum += num * weights[i];
            }
        }

        int remainder = sum % 11;
        int verifyNum;
        if (remainder == 0) {
            verifyNum = 0;
        } else if (remainder == 10) {
            verifyNum = 'X';
        } else {
            verifyNum = 11 - remainder;
        }
        char lastDigit = accountNum.charAt(accountNum.length() - 1);
        int expectedVerifyNum;
        if (lastDigit == 'X') {
            expectedVerifyNum = 10;
        } else {
            expectedVerifyNum = Character.getNumericValue(lastDigit);
        }

        return verifyNum == expectedVerifyNum;
    }
    public Account getAccount(String accountNum){
        if(!checkVerifyNum(accountNum))
            return null;
        for(Account account : accountList){
            if(account.getAccountNum().equals(accountNum)) {
                return account;
            }
        }
        return null;
    }


    /** 해당 은행 계좌를 분류해서 반환
     *
     * @param bankNum Bank클래스의 고유 코드
     * @return returnAccountList
     */

    public ArrayList<Account> getAllAccounts(int bankNum) {
        String bankCode = String.format("%03d", bankNum);
        ArrayList<Account> returnAccountList = new ArrayList<>();
        for (Account account : accountList){
            if (account.getAccountNum().substring(0,3).equals(bankCode))
                returnAccountList.add(account);
        }
        return returnAccountList;
    }
}
