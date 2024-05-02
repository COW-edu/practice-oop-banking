package view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EMenu {
	eMakeAccount("계좌 생성"),
	eWithdrawal("출금"),
	eDeposit("입금"),
	eRemittance("송금"),
	eAccountInfo("계좌 정보 확인"),
	eInterest("이자 확인"),
	eDeactivateAccount("계좌 비활성화"),
	eActivateAccount("계좌 활성화"),
	eDeleteAccount("계좌 삭제"),
	eQuit("종료");

	public static final int MIN_INDEX = 1;
	public static final int MAX_INDEX = EMenu.values().length;
	private final String menuText;
}
