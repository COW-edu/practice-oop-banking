package person;

import bank.BankKiosk;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor
public class Person {

    private static final int BANK_SERVICE = 1;
    private static final int END_BANK_SERVICE = 2;
    private static final int INVALID_CHOICE = -1;
    private static final String BANK_SERVICE_END_MESSAGE = "은행 업무 종료";
    private static final String INVALID_SELECTION_MESSAGE = "다시 선택해주세요.";
    private static final String MENU_OPTIONS = """
                        1. 은행 업무를 본다
                        2. 은행 업무를 보지 않는다.
                        """;

    private final Scanner scanner = new Scanner(System.in);
    private final BankKiosk service;
    private final Map<Integer, Runnable> menu = new HashMap<>();


    private void initialize() {
        menu.put(BANK_SERVICE, service::bankServiceMenu);
        menu.put(END_BANK_SERVICE, () -> System.out.println(BANK_SERVICE_END_MESSAGE));
        menu.put(INVALID_CHOICE, () -> System.out.println(INVALID_SELECTION_MESSAGE));
    }

    public void doBanking() {
        initialize();
        while (true) {
            menuList(); int choice = getUserChoice();
            menu.getOrDefault(choice, menu.get(-1)).run();
            if (choice == 2) break;}}

        private int getUserChoice() {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                return -1;}}

        private void menuList () {
            System.out.println(MENU_OPTIONS);}}

