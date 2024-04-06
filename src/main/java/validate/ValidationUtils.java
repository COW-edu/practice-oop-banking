package validate;

import account.Account;
import message.ErrorMessage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NoSuchElementException;

public class ValidationUtils {

    private static final String ACCOUNT_NUMBER_PATTERN = "\\d{10}";


    public static BigDecimal createBalance(String balance) {
        try {
            return new BigDecimal(balance);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.INSUFFICIENT_BALANCE.getErrorMessage());
        }
    }

    public static void isValidAccountNumber(String input) throws IllegalArgumentException {
        if (!input.matches(ACCOUNT_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ACCOUNT_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    public static Account validateAndGetAccount(Map<String, Account> list, String accountNum) throws IllegalStateException {
        Account account = getAccount(list, accountNum);
        if (!ValidationUtils.validateStatus(account)) {
            throw new IllegalStateException(String.format(ErrorMessage.INACTIVE_ACCOUNT_MESSAGE_FORMAT.getErrorMessage(), accountNum));
        }
        return account;
    }

    public static Account getAccount(Map<String, Account> accounts, String accountNum) throws NoSuchElementException {
        Account account = accounts.get(accountNum);
        if (account == null) {
            throw new NoSuchElementException(ErrorMessage.ACCOUNT_NOT_FOUND_ERROR.getErrorMessage());
        }
        return account;
    }

    public static boolean validateStatus(Account account) {
        return account.isAccountActive();
    }
}
