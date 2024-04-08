package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static util.ErrorMessage.*;

public class InputView {
    private static final String ASK_CATEGORY = "원하는 메뉴를 선택하세요%n";
    private static final String CATEGORY_CHOICE = "계좌생성(1), 계좌정보확인(2), 입금(3), 출금(4), 송금(5), 계좌해지(6), 프로그램종료(0)%n";
    private static final String ASK_ACCOUNT_INFORMATION = "계좌를 생성하기 위한 정보를 입력해주세요%n";
    private static final String ACCOUNT_INFORMATION_CATEGORY = "계좌종류(예금:N,적금S),이름,계좌번호(5자리),첫 입금액)%n";
    private static final String ACCOUNT_INFORMATION_EXAMPLE = "예시)N,박진현,12345,5000%n";
    private static final String ASK_TARGET_AMOUNT = "목표금액을 입력해주세요";
    private static final String ASK_ACCOUNT_NUMBER = "계좌번호를 입력해주세요";
    private static final String ASK_TRANSFER_INFORMATION = "입금자의 계좌번호, 상대방 계좌번호, 입금금액을 순서대로 입력해주세요";
    private static final String CATEGORY_NUMBER_REGEX = "^[0-6]{1}+$";
    private static final String ACCOUNT_NUMBER_REGEX = "^[0-9]{5}+$";
    private static final String ASK_NUMBER_AND_AMOUNT = "계좌번호와 금액을 입력하세요";
    private static final String ASK_DISABLE_ACCOUNT = "비활성화할 계좌번호를 입력해주세요";
    private static final String EXIT_PROGRAM = "프로그램을 종료합니다.";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int askCategory() {
        String choiceCategory;
        System.out.printf(ASK_CATEGORY + CATEGORY_CHOICE);
        choiceCategory = input();
        try {
            validateNumber(choiceCategory);
            return Integer.parseInt(choiceCategory);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askCategory();
        }
    }

    public static List<String> createAccount() {
        System.out.printf(ASK_ACCOUNT_INFORMATION + ACCOUNT_INFORMATION_CATEGORY + ACCOUNT_INFORMATION_EXAMPLE);//추후에 입력값 예외처리 필요
        List<String> accountDetails = makeList(input());
        try {
            validateAccountNumber(accountDetails.get(2));
            return checkAccountType(accountDetails);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return createAccount();
        }
    }

    public static List<String> transfer() {
        System.out.println(ASK_TRANSFER_INFORMATION);
        return makeList(input());
    }

    public static List<String> deposit() {
        System.out.println(ASK_NUMBER_AND_AMOUNT);
        return makeList(input());
    }

    public static List<String> withdraw() {
        System.out.println(ASK_NUMBER_AND_AMOUNT);
        return makeList(input());
    }

    private static List<String> checkAccountType(List<String> accountDetails) {
        List<String> updatedAccountDetails = new ArrayList<>(accountDetails);
        if (accountDetails.get(0).equals("S")) { //상수, 매직넘버 처리 해주기
            System.out.println(ASK_TARGET_AMOUNT);
            updatedAccountDetails.add(input());
            return updatedAccountDetails;
        }
        return updatedAccountDetails;
    }

    public static String disableAccount() {
        System.out.println(ASK_DISABLE_ACCOUNT);
        return validateAccountNumber(input());
    }

    private static String input() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void validateNumber(String input) {
        if (!input.matches(CATEGORY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(CATEGORY_OUT_OF_LANGE.getMessage());
        }
    }
    private static String validateAccountNumber(String input) {
        if (!input.matches(ACCOUNT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_NUMBER.getMessage());
        }
        return input;
    }
    private static List<String> makeList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim) // 앞뒤 공백 제거
                .map(s -> s.replaceAll(" ", ""))// 모든공백제거
                .toList(); // 결과를 수집
    }
    public static void exitProgram() {
        System.out.println(EXIT_PROGRAM);
    }

    public String getAccountInfo() {
        System.out.println(ASK_ACCOUNT_NUMBER);
        return input();
    }
}
