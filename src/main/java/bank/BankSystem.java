package bank;

import account.Account;
import message.ErrorMessage;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class BankSystem {

    private final BankStorage bankStorage;

    public String createAccount(Account account) {
        String accountNum = createAccountNum();
        return bankStorage.save(account, accountNum);
    }

    public String deposit(String accountNum, BigDecimal balance) throws IllegalStateException {
        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        if (ValidationUtils.validateStatus(account)) {
            return account.deposit(balance);
        }
        throw new IllegalStateException(String.format(ErrorMessage.INACTIVE_ACCOUNT_MESSAGE_FORMAT.getErrorMessage(), accountNum));
    }

    public String withdraw(String accountNum, BigDecimal balance) throws IllegalStateException {

        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        if (ValidationUtils.validateStatus(account)) {
            return account.withdraw(balance);
        }
        throw new IllegalStateException(String.format(ErrorMessage.INACTIVE_ACCOUNT_MESSAGE_FORMAT.getErrorMessage(), accountNum));
    }

    public String remittance(String fromAccountNum, String toAccountNum, BigDecimal balance) throws IllegalStateException {

        Account toAccount = ValidationUtils.validateAndGetAccount(getAllList(), fromAccountNum);
        Account fromAccount = ValidationUtils.validateAndGetAccount(getAllList(), toAccountNum);

        String message = toAccount.withdrawForTransfer(balance);
        fromAccount.depositForTransfer(balance);
        return message;
    }

    public String changeStatus(String accountNum) throws IllegalStateException {
        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        return account.changeStatus();
    }

    public String getAccountInfo(String accountNum) throws IllegalStateException {
        Account account = ValidationUtils.getAccount(getAllList(), accountNum);
        return account.getAccountInfo();
    }

    private Map<String, Account> getAllList() {
        return bankStorage.getAllAccount();
    }

    private String createAccountNum() {
        return Long.toString(ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L));
    }
}
