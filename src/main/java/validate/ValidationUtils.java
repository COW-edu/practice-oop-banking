package validate;

import account.Account;
import exception.system.AccountStatusException;
import exception.clerk.InputAccountNumberException;
import exception.system.NotFoundAccountException;

import java.math.BigDecimal;
import java.util.Map;

public class ValidationUtils {
    private static final String INVALID_AMOUNT_MESSAGE = "잘못된 금액입니다. 처음부터 다시 입력해주세요.";
    private static final String INVALID_ACCOUNT_NUMBER_MESSAGE = "계좌번호 형식이 올바르지 않습니다. 다시 입력해주세요";
    private static final String ACCOUNT_NUMBER_PATTERN = "\\d{10}";
    private static final String INACTIVE_ACCOUNT_MESSAGE_FORMAT = "[%s] 계좌가 비활성화 상태입니다.";
    private static final String ACCOUNT_NOT_FOUND_ERROR = "존재하지 않는 계좌입니다 처음부터 다시 입력해주세요.";


    public static BigDecimal createBalance(String balance){
        try{
            return new BigDecimal(balance);
        }catch (NumberFormatException e){
            throw new NumberFormatException(INVALID_AMOUNT_MESSAGE);
        }
    }
    public static void isValidAccountNumber(String input) throws InputAccountNumberException {
        if(!input.matches(ACCOUNT_NUMBER_PATTERN)){
            throw new InputAccountNumberException(INVALID_ACCOUNT_NUMBER_MESSAGE);
        }
    }
    public static Account validateAndGetAccount(Map<String, Account> list, String accountNum) throws NotFoundAccountException, AccountStatusException {
        Account account = getAccount(list, accountNum);
        if (!ValidationUtils.validateStatus(account)) {
            throw new AccountStatusException(String.format(INACTIVE_ACCOUNT_MESSAGE_FORMAT, account.getAccountNum()));
        }
        return account;
    }

    public static Account getAccount(Map<String, Account> list, String accountNum) throws NotFoundAccountException {
        Account account = list.get(accountNum);
        if(account == null){
            throw new NotFoundAccountException(ACCOUNT_NOT_FOUND_ERROR);
        }
        return account;
    }

    public static boolean validateStatus(Account account){
        return account.getStatus();
    }
}
