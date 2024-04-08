package interest;

import model.Account;
import model.GeneralAccount;
import model.SavingsAccount;
import java.math.BigDecimal;
import static interest.InterestList.*;

public class RateInterestPolicy implements InterestPolicy {
    @Override
    public BigDecimal interest(Account account) {
        if (account instanceof SavingsAccount) {
            return savingsInterest(account.getAmount());
        }
        if (account instanceof GeneralAccount) {
            return generalInterest(account.getAmount());
        }
        throw new IllegalArgumentException();//예외처리 해줄것
    }

    private BigDecimal savingsInterest(BigDecimal amount) {
        if (amount.compareTo(OVERHUNDRED.getAccountAmount()) > -1) {
            return amount.add(amount.multiply(OVERHUNDRED.getSavingsAccountInterest()));
        }
        return amount.add(amount.multiply(REMAIN.getSavingsAccountInterest()));
    }

    private BigDecimal generalInterest(BigDecimal amount) {
        if (amount.compareTo(OVERTHOUSAND.getAccountAmount()) > -1) { //왼쪽값이 우측값이상일경우
            return amount.add(amount.multiply(OVERTHOUSAND.getGeneralAccountInterest()));
        }
        if (amount.compareTo(OVERFIVEHUNDRED.getAccountAmount()) > -1) {
            return amount.add(amount.multiply(OVERFIVEHUNDRED.getGeneralAccountInterest()));
        }
        if (amount.compareTo(OVERHUNDRED.getAccountAmount()) > -1) {
            return amount.add(amount.multiply(OVERHUNDRED.getGeneralAccountInterest()));
        }
        if (amount.compareTo(OVERONE.getAccountAmount()) > -1) {
            return amount.add(amount.multiply(OVERONE.getGeneralAccountInterest()));
        }
        return amount.add(amount.multiply(REMAIN.getGeneralAccountInterest()));
    }
}
