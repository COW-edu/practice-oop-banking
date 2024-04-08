package util;

public enum ErrorMessage {

    CATEGORY_OUT_OF_LANGE("[ERROR] 1~6사이숫자를 입력해주세요"),
    WRONG_FORM("[ERROR] 양식에 맞게 입력해주세요"),
    WRONG_ACCOUNT_NUMBER("[ERROR]계좌번호는 5자리입니다."),
    NOT_ENOUGH_MONEY("[ERROR] 계좌 잔액이 부족합니다."),
    FAIL_TO_GOAL("[ERROR]계좌 잔액이 목표금액에 도달하지 못했습니다");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
