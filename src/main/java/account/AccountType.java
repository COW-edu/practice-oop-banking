package account;

import message.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum AccountType {

    DEPOSIT("예금 계좌"),
    SAVING("적금 계좌");

    private final String type;

    public static AccountType fromDescription(String input) throws IllegalStateException {
        return Arrays.stream(AccountType.values())
                .filter(type -> type.getType().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.INVALID_ACCOUNT_TYPE.getErrorMessage()));
    }
}