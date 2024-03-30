package bank;

import bank.clerk.*;
import person.PersonalInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class BankKiosk implements IBankService {

    private final Clerk clerk;
    private Map<Integer, Consumer<PersonalInfo>> actions;

    public BankKiosk(Clerk clerk) {
        this.clerk = clerk;
        initActions();
    }

    private void initActions() {
        clerks = new HashMap<>();
        clerks.put(1, new CreateAccountClerk());
        clerks.put(2, new DepositClerk());
        clerks.put(3, new WithdrawClerk());
        clerks.put(4, new RemittanceClerk());
    }

    public void bankServiceMenu(PersonalInfo personalInfo) {

        try {menuList();
            int choice = promptMenuSelection();
            Consumer<PersonalInfo> action = actions.get(choice);

            if (action != null) {
                action.accept(personalInfo);
            } else throw new InvalidInputException("잘못된 입력입니다.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());}}


    private int promptMenuSelection() {
        Scanner scanner = new Scanner(System.in);
        menuList();
        int choice = scanner.nextInt(); scanner.nextLine();
        return choice;
    }

    private void menuList() {
        System.out.println("""
                1. 계좌 생성
                2. 입금
                3. 출금
                4. 송금
                """);
    }
    private static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}