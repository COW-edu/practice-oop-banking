package org.example.bank;

public class BankController {
    private  Bank bank;

    public BankController(Bank bank){
        this.bank =bank;
    }
    public boolean login(String id, String pw) {
        boolean ok = false;
        for (int i = 0; i < bank.accountList.size(); i++) {
            if (bank.users.get(i).SuccessLogin(id, pw)) {
                ok = true;
                bank.accountcnt = i;
                break;
            }
        }
        return ok;
    }

    public void logout() {
        bank.accountLog = -1;
        System.out.println("로그아웃 완료.");
    }




}
