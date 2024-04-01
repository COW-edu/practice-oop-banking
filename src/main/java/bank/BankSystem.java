package bank;

import account.Account;
import exception.system.AccountStatusException;
import exception.account.BelowTargetException;
import exception.account.InsufficienBalancetException;
import exception.system.NotFoundAccountException;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class BankSystem {

    private static final String ACCOUNT_INACTIVE_ERROR = "비활성화 계좌입니다.";

    private final BankStorage bankStorage;

    public String createAccount(Account account) {
        String accountNum = createAccountNum();
        account.setAccountNum(accountNum);
        return bankStorage.save(account);
    }

    public String deposit(String accountNum, BigDecimal balance) throws AccountStatusException, NotFoundAccountException {
        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        if (ValidationUtils.validateStatus(account)) {

            return account.deposit(balance);}
        throw new AccountStatusException(ACCOUNT_INACTIVE_ERROR);
    }

    public String withdraw(String accountNum, BigDecimal balance)
            throws AccountStatusException, NotFoundAccountException, InsufficienBalancetException, BelowTargetException {

        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        if (ValidationUtils.validateStatus(account)) {
            return account.withdraw(balance);}
        throw new AccountStatusException(ACCOUNT_INACTIVE_ERROR);
    }

    public String remittance(String fromAccountNum, String toAccountNum, BigDecimal balance)
            throws AccountStatusException, NotFoundAccountException, InsufficienBalancetException, BelowTargetException {

        Account toAccount = ValidationUtils.validateAndGetAccount(getAllList(), fromAccountNum);
        Account fromAccount = ValidationUtils.validateAndGetAccount(getAllList(), toAccountNum);

        String message = toAccount.withdrawForTransfer(balance);
        fromAccount.depositForTransfer(balance);
        return message;
    }

    public String changeStatus(String accountNum) throws NotFoundAccountException {
        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        return account.changeStatus();
    }
    public String getAccountInfo(String accountNum) throws NotFoundAccountException {
        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        return account.getAccountInfo();
    }
    private Map<String, Account> getAllList(){
        return bankStorage.getAllAccount();
    }
    private String createAccountNum(){
        return Long.toString(ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L));
    }

}
