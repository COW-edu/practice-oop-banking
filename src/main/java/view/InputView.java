package view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_CATEGORY = "원하는 메뉴를 선택하세요%n";
    private static final String CATEGORY_CHOICE = "계좌생성(1), 계좌정보확인(2), 입금(3), 출금(4), 송금(5), 계좌해지(6), 프로그램종료(0)%n";
    private static final String ASK_ACCOUNT_INFORMATION = "계좌를 생성하기 위한 정보를 입력해주세요%n";
    private static final String ACCOUNT_INFORMATION_CATEGORY = "계좌종류(예금:N,적금S),이름,계좌번호(5자리),첫 입금액)%n";
    private static final String ACCOUNT_INFORMATION_EXAMPLE = "예시)N,박진현,12345,5000%n";
    private static final String ASK_TARGET_AMOUNT= "목표금액을 입력해주세요";
    private static final String NUMBER_REGEX = "^[0-6]{1}+$";
    private static final String DELIMITER = ",";
    private static final String EXIT_PROGRAM = "프로그램을 종료합니다.";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void terminateAccount() {

    }

    public static void transfer() {
    }

    public static void deposit() {
    }

    public static void withdraw() {
    }

    public static List<String> createAccount() {
        System.out.printf(ASK_ACCOUNT_INFORMATION+ACCOUNT_INFORMATION_CATEGORY+ACCOUNT_INFORMATION_EXAMPLE);//추후에 입력값 예외처리 필요
        String accountInformation = input();
        List<String> accountDetails = Arrays.stream(accountInformation.split(","))
                .map(String::trim) // 앞뒤 공백 제거
                .map(s -> s.replaceAll(" ", ""))// 모든공백제거
                .toList(); // 결과를 수집

        return checkAccountType(accountDetails);
    }

    private static List<String>  checkAccountType(List<String> accountDetails) {
        List<String> updatedAccountDetails = new ArrayList<>(accountDetails);
        if(accountDetails.get(0).equals("S")){ //상수, 매직넘버 처리 해주기
            System.out.println(ASK_TARGET_AMOUNT);
            updatedAccountDetails.add(input());
            return updatedAccountDetails;
        }
        return updatedAccountDetails;
    }

    public static int askCategory() {
        String choiceCategory;
            System.out.printf(ASK_CATEGORY + CATEGORY_CHOICE);
            choiceCategory = input();
            validateNumber(choiceCategory);
        return Integer.parseInt(choiceCategory);
    }


    private static String input() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(); //나중에 예외처리
        }
    }

    public static void exitProgram() {
    }

    public String getAccountInfo() {
        return "12345";
    }
}
