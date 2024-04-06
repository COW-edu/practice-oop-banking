package bankSevice;

import java.math.BigDecimal;

public interface Account {
    String getBankAccountNumber();

    String getAccountType();

    BigDecimal getAmount();

    String getName();

    void setAmount(BigDecimal add);
}
