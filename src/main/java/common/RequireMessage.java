package common;

import account.AccountType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RequireMessage {
  RequireAccountType(accountTypeMessage()),
  RequireOwner("계좌주의 이름을 입력해주세요."),
  RequireActivation("계좌 활성화 상태를 입력해주세요. ( 0 : 비활성화 / 1 : 활성화)"),
  RequireAmount("0 보다 큰 금액을 입력해주세요."),
  RequireAccountNumber("계좌번호를 입력해주세요.");

  private final String printMessage;

  private static String accountTypeMessage(){
    StringBuilder accountTypeBuilder = new StringBuilder();
    accountTypeBuilder.append("[계좌 종류 선택]");
    for(AccountType accountType : AccountType.values()){
      accountTypeBuilder.append("\n")
          .append(accountType.ordinal() + AccountType.MIN_INDEX)
          .append(". ")
          .append(accountType.getAccountName());
    }
    return accountTypeBuilder.toString();
  }
}
