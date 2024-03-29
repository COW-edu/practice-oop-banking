package utility;

import java.math.BigDecimal;
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
                String input = scanner.next();
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

    public static int selectMenu(String[] menus){
        systemMsg("원하시는 업무를 선택해주세요.");
        int select = -999;
        while (0 < select && select < menus.length+1){
            for (int i = 0; i < menus.length; i++){
                System.out.println("    " + (i+1) + ". " + menus[i]);
            }
            try {
                select = scanner.nextInt();
            }catch (Exception e){
                systemMsg("숫자만 입력가능합니다.");
            }
            systemMsg("1  ~ "+menus.length+"사이의 숫자를 선택하세요");
        }
        return select;
    }

    public static String inputAsString(String msg){
        systemMsg(msg);
        userInputMark();
        return scanner.nextLine();
    }
    public static String inputAsAccountNum(String msg){
        boolean validInput = false;
        String str = "";
        while (!validInput){
            systemMsg(msg);
            userInputMark();
            str = scanner.nextLine();



        }
        return str;
    }

}
