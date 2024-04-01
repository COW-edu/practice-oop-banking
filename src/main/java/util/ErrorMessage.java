package util;

public enum ErrorMessage {

    CATEGORY_OUT_OF_LANGE("[ERROR] 1~6사이숫자를 입력해주세요"),
    WRONG_FORM("[ERROR] 양식에 맞게 입력해주세요"),
    WRONG_ACCOUNT_NUMBER("[ERROR]계좌번호는 5자리입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
