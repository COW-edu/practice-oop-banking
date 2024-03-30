package account;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public interface Account {

    public void setAccountNum(String accountNum);

    String deposit(BigDecimal balance);
}
