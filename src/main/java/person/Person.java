package person;

import bank.BankKiosk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Person {
    private final Scanner scanner = new Scanner(System.in);
    private final BankKiosk service;
    private final Map<Integer, Runnable> menu = new HashMap<>();

    public Person(BankKiosk service) {
        this.service = service;
        initialize();
    }

    private void initialize() {
        menu.put(1, service::bankServiceMenu);
        menu.put(2, () -> System.out.println("은행 업무 종료"));
        menu.put(-1, () -> System.out.println("잘못된 입력입니다."));
    }

    public void doBanking() {
        while (true) {
            menuList();
            int choice = getUserChoice();
            menu.getOrDefault(choice, menu.get(-1)).run();
            if (choice == 2) break;
        }
    }
        private void menuList () {
            System.out.println("""
                    1. 은행 업무를 본다
                    2. 은행 업무를 보지 않는다.
                    """);
        }
        private int getUserChoice() {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

