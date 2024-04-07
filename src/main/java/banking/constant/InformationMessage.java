package banking.constant;


import lombok.Getter;

@Getter
public enum InformationMessage {

  MENU("(1) : 계좌 생성  (2) : 입금 (3) : 출금 (4) : 송금 (5) 계좌조회 (6) 프로그램 종료"),
  ACCOUNT_TYPE("(1) : 예금 계좌 , (2) : 적금 계좌"),
  ACCOUNT_NUMBER("계좌번호를 입력하세요. (8자리 입력)"),
  ACCOUNT_OWNER("이름을 입력하세요."),
  DEPOSIT_ACCOUNT_NUMBER("입금계좌번호를 입력하세요. (8자리 입력) "),
  WITHDRAW_ACCOUNT_NUMBER("출금계좌번호를 입력하세요. (8자리 입력) "),
  TRANSFER_ACCOUNT_NUMBER("송금금액을 입력하세요. "),
  TARGET_AMOUNT("목표금액을 입력하세요. "),
  DEPOSIT_AMOUNT("입금금액을 입력하세요. "),
  WITHDRAW_AMOUNT("출금금액을 입력하세요. "),
  TRANSFER_AMOUNT("송금금액을 입력하세요. "),
  ACCOUNT_INFO("계좌의 정보는 다음과 같습니다."),
  EXIT("프로그램을 종료합니다.");

  private final String message;

  InformationMessage(String message) {
    this.message = message;
  }


}
