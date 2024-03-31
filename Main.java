import bank.Bank;
import bank.CentralBank;
import utility.Dialog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dialog.scanner = new Scanner(System.in);
        //Bank의 parameter로 scanner를 넘기는것과 이 방식중 뭐가 더 나은지 고민..

        CentralBank centralBank = new CentralBank();
        Bank bank = new Bank();
        bank.associate(centralBank);
        bank.run();
    }


}
