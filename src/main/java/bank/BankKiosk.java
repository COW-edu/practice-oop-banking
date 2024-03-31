package bank;

import java.util.Scanner;

public class BankKiosk {

    private final BankServiceMediator clerkFacade;
    private final Scanner scanner = new Scanner(System.in);
    public BankKiosk(BankServiceMediator clerkFacade) {
        this.clerkFacade = clerkFacade;
    }

    public void bankServiceMenu() {
        try {
            int choice = promptMenuSelection();
            clerkFacade.executeAction(choice);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
    private int promptMenuSelection() {
        menuList();
        while (!scanner.hasNextInt()) {
            System.out.println("유효한 번호를 입력해주세요.");
            scanner.next();
            menuList();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void menuList() {
        System.out.println("""
                1. 계좌 생성
                2. 입금
                3. 출금
                4. 송금
                5. 계좌상태 변경
                """);
    }
    private static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}