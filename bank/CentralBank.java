package bank;

import accountfile.Account;

import java.util.ArrayList;

public class CentralBank {

    private static CentralBank instance = new CentralBank();
    private AccountList accountList = new AccountList();

    private CentralBank(){}

    // getInstance 함수
    public static CentralBank getInstance(){//<- 싱글톤을 위해서.
        if(instance == null)
            instance = new CentralBank();
        return instance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    // accountList getter/setter <- 중앙은행 인스턴스와 계좌 접근 가능
    public final AccountList getAccountList() {
        return accountList;
    }

    public void setAccountList(AccountList accountList) {
        this.accountList = accountList;
    }

    public static class AccountList {
        private ArrayList<Account> accountList;

        public AccountList() {
            this.accountList = new ArrayList<>();
        }

        public void add(Account account) {
            accountList.add(account);
        }

        public ArrayList<Account> getAccountList() {
            return accountList;
        }

        public void setAccountList(ArrayList<Account> accountList) {
            this.accountList = accountList;
        }

    }
}
