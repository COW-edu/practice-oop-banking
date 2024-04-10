package Week2.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
//@AllArgsConstructor
public enum AccountType {
    NORMAL_ACCOUNT("예금 계좌"),
    SAVING_ACCOUNT("적금 계좌");

    private final String accountName;
}