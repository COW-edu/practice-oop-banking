package org.example.bank;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankView {
    private Scanner sc;

    public BankView() {
        this.sc = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMainMenu() {
        System.out.println("1.계정생성 2.계정삭제 3.로그인 4.로그아웃 5. 종료");
    }

    public BigDecimal getBigDecimalInput(String prompt) {
        System.out.println(prompt);
        return new BigDecimal(sc.nextLine());
    }

    public void displayBankInfo(String bankName, int accountSize) {
        System.out.println("현재 사용하고 계신 은행 : " + bankName);
        System.out.println("총 계좌 수: " + accountSize);
    }
}