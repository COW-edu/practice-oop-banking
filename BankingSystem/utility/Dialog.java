package BankingSystem.utility;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class Dialog {

    public static Scanner scanner;
    public static void separator1(){
        System.out.println("------------------------------------------");
        System.out.println();
    }
    public static void separator2(){
        System.out.println("==========================================");
        System.out.println();
    }
    public static BigDecimal inputAsBigDecimal(){
        BigDecimal result = null;
        while (result == null) {
            try {
                userInputMark();
                String input = scanner.nextLine();
                result = new BigDecimal(input);
            } catch (NumberFormatException e) {
                systemMsg("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        return result;
    }
    public static BigDecimal inputAsBigDecimal(String msg){
        systemMsg(msg);
        return inputAsBigDecimal();
    }
    public static void systemMsg(String msg){
        System.out.println("[시스템] : " + msg);
    }

    public static void userInputMark(){
        System.out.print(" >> ");
    }

    public static int selectMenu(Object[] menus){
        systemMsg("원하시는 항목을 선택해주세요.");
        int select = -999;
        showMenus(menus);
        select = selectInRange(menus.length);
        return select;
    }

    public static String inputAsString(String msg){
        systemMsg(msg);
        userInputMark();
        return scanner.nextLine();
    }
    public static String inputAsAccountNum(String msg){
        /** 계좌번호는 정수로 이루어진 11자 문자열이고, 첫자리의 0도 생략하면 안되므로
         *  형식에 맞는 String으로 입력받기위한 메소드
         */
        boolean validInput = false;
        String str = "";
        while (!validInput){
            systemMsg(msg);
            userInputMark();
            str = scanner.nextLine();
            validInput = str.matches("\\d+") && str.length() == 11;
        }
        return str;
    }

    public static void showMenus(Object[] menus){
        for (int i = 0; i < menus.length; i++){
            System.out.println("    " + i + ". " + menus[i]);
        }
    }


    /** 0 부터 range개의 정수를 입력 받아 리턴
     * 범위 밖의 값이 입력되거나 정수가 아닌값이 입력되면
     * 다시 입력받음.
     */
    public static int selectInRange(int range){
        int select = -1;
        while (select < 0 || select >= range) {
            try {
                select = Integer.parseInt(scanner.nextLine());
                if (select < 0 || select >= range) {
                    systemMsg("0 ~ " + (range - 1) + " 사이의 숫자를 선택하세요.");
                }
            } catch (NumberFormatException e) {
                systemMsg("숫자만 입력 가능합니다.");
            }
        }
        return select;
    }

}
