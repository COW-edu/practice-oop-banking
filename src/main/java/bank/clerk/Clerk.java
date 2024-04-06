package bank.clerk;

import global.GlobalScanner;

import java.util.Scanner;

public interface Clerk {

    void action();

    default String getUserInput() {
        Scanner scanner = GlobalScanner.getScanner();
        return scanner.nextLine().trim();
    }

    default void resultMessage(String balanceResult) {
        System.out.println(balanceResult);
    }
}
