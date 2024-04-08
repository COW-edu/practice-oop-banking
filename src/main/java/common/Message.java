package common;

import view.EMenu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Message {
  SELECT_MENU(makeMenu()),
  Exit("프로그램이 종료되었습니다."),
  AccountCreationFailed("계좌 생성에 실패하였습니다."),
  Withdrawal("출금"),
  Deposit("입금"),
  Remittance("송금"),
  Delete("삭제"),
  Activate("활성화"),
  Deactivate("비활성화"),
  Amount("금액"),
  Target("목표"),
  Complete("성공하였습니다."),
  Balance("잔액"),
  Interest("이자");

  private final String printMessage;

  private static String makeMenu() {
    StringBuilder menuBuilder = new StringBuilder();
    menuBuilder.append("[메뉴 선택]");
    for(EMenu eMenu : EMenu.values()){
      menuBuilder.append("\n")
          .append(eMenu.ordinal() + EMenu.MIN_INDEX)
          .append(". ")
          .append(eMenu.getMenuText());
    }
    return menuBuilder.toString();
  }
}
