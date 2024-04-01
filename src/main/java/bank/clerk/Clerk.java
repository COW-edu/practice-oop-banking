package bank.clerk;

import java.util.Scanner;

public interface Clerk {

     void action();

     default String getUserInput() {
          Scanner scanner = new Scanner(System.in);
          return scanner.nextLine().trim();
     }
     default void resultMessage(String balanceResult){
          System.out.println(balanceResult);
     }
}
