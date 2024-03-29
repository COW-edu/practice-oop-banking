package view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String ASK_CATEGORY = "원하는 메뉴를 선택하세요%n";
    private static final String CATEGORY_CHOICE = "계좌생성:1, 출금:2, 입금:3, 송금:4, 계좌해지:5, 프로그램종료:0%n";
    private static final String NUMBER_REGEX = "^[0-5]{1}+$";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int askCategory() {
        System.out.printf(ASK_CATEGORY+CATEGORY_CHOICE);
        String choiceCategory = input();
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
}
