package bank;

import global.GlobalScanner;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class BankKiosk {

    private static final String MENU_LIST = "1.계좌생성, 2.입금, 3.출금, 4.송금, 5.계좌상태 변경, 6.계좌 정보 조회, 7.종료";
    private static final String ERROR_MESSAGE = "유효한 번호를 입력해주세요.";
    private static final int INITIALIZE_VALUE = 0;
    private static final int MIN_MENU_OPTION = 1;
    private static final int MAX_MENU_OPTION = 6;
    private static final int EXIT_OPTION = 7;
    private final BankServiceMediator clerkFacade;
    private final Scanner scanner = GlobalScanner.scanner;


    public void bankServiceMenu() {
        boolean completed = false;
        while (!completed){
            int choice = promptMenuSelection();
            if(choice == EXIT_OPTION){
                completed = true;
            }
            clerkFacade.executeAction(choice);
        }
    }

    private int promptMenuSelection() {
        boolean isValidChoice = false;
        int choice = INITIALIZE_VALUE;
        menuList();
        while (!isValidChoice) {
            while (!scanner.hasNextInt()) {
                System.out.println(ERROR_MESSAGE);
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= MIN_MENU_OPTION && choice <= MAX_MENU_OPTION) {
                isValidChoice = true;
            }else{
                System.out.println(ERROR_MESSAGE);
            }
        }
        return choice;
    }

    private void menuList() {
        System.out.println(MENU_LIST);
    }
}