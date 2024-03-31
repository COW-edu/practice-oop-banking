package account;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public interface Account {

    public void setAccountNum(String accountNum);

    String deposit(BigDecimal balance);

    String withdraw(BigDecimal balance);

    String getAccountNum();

    void depositForTransfer(BigDecimal balance);

    String withdrawForTransfer(BigDecimal balance);

    String changeStatus();
}
