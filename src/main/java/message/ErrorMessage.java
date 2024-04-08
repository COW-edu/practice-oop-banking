package message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {

    INVALID_AMOUNT_MESSAGE("잘못된 금액입니다. 처음부터 다시 입력해주세요."),
    INVALID_ACCOUNT_NUMBER_MESSAGE("계좌번호 형식이 올바르지 않습니다. 다시 입력해주세요"),
    INVALID_ACCOUNT_TYPE("계좌유형을 다시 입력해주세요. ex) 예금 계좌, 적금 계좌"),
    ACCOUNT_NOT_FOUND_ERROR("존재하지 않는 계좌입니다 처음부터 다시 입력해주세요."),
    INSUFFICIENT_BALANCE("잔액부족! [잔고] = %s 처음부터 다시 입력해주세요"),
    BELOW_TARGET("목표금액 이하! [잔고] = %s"),
    INACTIVE_ACCOUNT_MESSAGE_FORMAT("[%s] 계좌가 비활성화 상태입니다.");

    private final String errorMessage;
}