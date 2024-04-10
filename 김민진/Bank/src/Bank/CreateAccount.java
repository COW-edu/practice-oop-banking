package Bank;

import java.util.Scanner;

public class CreateAccount {
    private static Account[] accounts = new Account[100];
    private static int index = 0;
    private static Scanner scanner = new Scanner(System.in);
    
    // 계좌 생성 메서드
    public static void createAccount() {
        // 사용자로부터 계좌 정보 입력 받기
        System.out.print("Enter account type: ");
        String type = scanner.nextLine();
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial balance: ");
        int balance = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter activation status (true/false): ");
        boolean isActivated = Boolean.parseBoolean(scanner.nextLine());
        
        // 새로운 계좌 객체 생성
        Account account = new Account(type, accountNumber, name, balance, isActivated);
        
        // 계좌 배열에 추가
        accounts[index++] = account;
    }
    
    // 계좌 목록 출력 메서드
    public static void displayAccountList() {
        System.out.println("Account List:");
        for (int i = 0; i < index; i++) {
            System.out.println(accounts[i]);
        }
    }
    
    // 특정 계좌 조회 메서드
    public static void findAccount() {
        System.out.print("Enter account number to find: ");
        String accountNumber = scanner.nextLine();
        
        for (int i = 0; i < index; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                System.out.println("Account found:");
                System.out.println(accounts[i]);
                return;
            }
        }
        System.out.println("Account not found.");
    }
    
    // 계좌 비활성화 메서드
    public static void deactivateAccount() {
        System.out.print("Enter account number to deactivate: ");
        String accountNumber = scanner.nextLine();
        
        for (int i = 0; i < index; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i].setActivated(false);
                System.out.println("Account deactivated successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
