package bank;

import utility.Dialog;

public class Bank {
    enum EState{
        CONNECTED,
        DISCONNECTED
    }
    private String[] menuTable = {"계좌생성", "출금", "입금", "송금", "계좌정보 확인", "이전으로"};
    private static int nOfBanks = 0;

    private int bankNum;

    private EState eState;


    public int getBankNum() {
        return bankNum;
    }

    public Bank(){
        bankNum = nOfBanks++;
        eState = EState.CONNECTED;
    }

    public void createAccount(){
        String name = input
    }


    public void selectMenu(){
        switch (Dialog.selectMenu(this.menuTable)){
            case 1 -> createAccount();
            case 2 -> withdraw();
            case 3 -> deposit();
            case 4 -> remit();
            case 5 -> getAccountInfo();
        }
    }

    private void withdraw() {

    }

    public void run() {
        while (eState == EState.CONNECTED){
            selectMenu();
        }
    }
}
