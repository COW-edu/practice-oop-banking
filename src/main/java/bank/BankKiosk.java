package bank;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class BankKiosk {

    private static final String MENU_LIST = "1.계좌생성, 2.입금, 3.출금, 4.송금, 5.계좌상태 변경, 6.계좌 정보 조회";
    private static final String ERROR_MESSAGE = "유효한 번호를 입력해주세요.";
    private final BankServiceMediator clerkFacade;
    private final Scanner scanner = new Scanner(System.in);


    public void bankServiceMenu() {
            int choice = promptMenuSelection();
            clerkFacade.executeAction(choice);

    }
    private int promptMenuSelection() {
        int choice;
        while (true) {
            menuList();
            while (!scanner.hasNextInt()) {
                System.out.println(ERROR_MESSAGE);
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 1 && choice <= 6) {
                return choice;
            }
            System.out.println(ERROR_MESSAGE);
        }
    }
    private void menuList() {
        System.out.println(MENU_LIST);
    }
}