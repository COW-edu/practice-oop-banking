package banking.constant;

import lombok.Getter;

@Getter
public enum ErrorMessage {

  IS_EXISTED_NUMBER("존재하지 않는 계좌번호입니다.다시 확인해 주세요."),
  CHECK_GOAL_AMOUNT("목표 금액이 충족되지 않았습니다."),
  EXCLUDE_KOREAN("한글을 포함할 수 없습니다"),
  TYPE_FOR_DECIMAL("숫자로 입력해주세요."),
  TYPE_FOR_ACCOUNT("계좌형식에 맞춰주세요."),
  INCORRECT_INPUT("잘못된 입력입니다. 다시 입력해주세요.");

  private final String errorMessage;

  ErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
