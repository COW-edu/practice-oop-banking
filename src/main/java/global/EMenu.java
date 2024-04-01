package global;

public enum EMenu {
	eMakeAccount("계좌 생성"),
	eWithdrawal("출금"),
	eDeposit("입금"),
	eRemittance("송금"),
	eAccountInfo("계좌 정보 확인"),
	eInterest("이자 확인"),
	eDeactiveAccount("계좌 비활성화"),
	eActiveAccount("계좌 활성화"),
	eDeleteAccount("계좌 삭제"),
	eQuit("종료");

	private String menuText;
	EMenu(String menuText) {
		this.menuText = menuText;
	}
	public String getMenuText() {
		return this.menuText;
	}
	public static EMenu selectedMenu(int selectedInt) {
		EMenu[] menuList = EMenu.values();
		if(selectedInt-1 < 0 || selectedInt-1 > menuList.length)
			return null;
		return menuList[selectedInt-1];
	}
}
