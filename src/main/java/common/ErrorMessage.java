package common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorMessage {
  NumberFormat("숫자를 입력해주세요."),
  NegativeNumber("0보다 큰 숫자를 입력해주세요."),
  NotExistAccount("존재하지 않는 계좌입니다."),
  IndexOutOfRange("숫자가 범위를 초과하였습니다."),
  MaxAccountCount("계좌를 더 이상 만들 수 없습니다."),
  AccountTypeException("잘못된 계좌 종류입니다."),
  DeactivatedAccount("비활성화된 계좌입니다."),
  NotEnoughBalanceException("현재 잔액으로는 송금할 수 없는 금액입니다. 잔액 또는 목표금액을 확인해주세요.");

  private final String printMessage;
}
