package message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    DEPOSIT_COMPLETE("입금완료! [잔고] = %s"),
    WITHDRAW_COMPLETE("출금완료! [잔고] = %s"),
    REMITTANCE_COMPLETE("송금완료! [잔고] = %s"),
    ACCOUNT_INACTIVE("[계좌상태] = 비활성화"),
    ACCOUNT_ACTIVE("[계좌상태] = 활성화"),
    DISPLAY_ACCOUNT_INFO("[계좌유형] = %s [계좌번호] = %s [소유자] = %s [잔액] = %s [활성화 여부] = %s");

    private final String successMessage;

}