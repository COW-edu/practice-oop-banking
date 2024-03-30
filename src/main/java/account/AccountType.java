package account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountType {
	DEPOSIT("예금 계좌"),
	SAVING("적금 계좌");

	private final String accountName;
}