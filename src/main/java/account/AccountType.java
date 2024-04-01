package account;

import exception.clerk.InputAccountTypeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum AccountType {

	DEPOSIT("예금 계좌"),
	SAVING("적금 계좌");

	private static final String ERROR_MESSAGE = "계좌유형을 다시 입력해주세요. ex) 예금 계좌, 적금 계좌";
	private final String type;

	public static AccountType fromDescription(String input) throws InputAccountTypeException{
		return Arrays.stream(AccountType.values())
				.filter(type -> type.getType().equals(input))
				.findFirst()
				.orElseThrow(() -> new InputAccountTypeException(ERROR_MESSAGE));
	}
}