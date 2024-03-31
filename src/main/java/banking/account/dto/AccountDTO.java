package banking.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class AccountDTO {
    private int typeNum;
    private String accountNumber;
    private String owner;
    private String money;
    private String targetAmount;

    public AccountDTO(int typeNum, String accountNumber, String owner, String money) {
        this.typeNum = typeNum;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.money = money;
    }


}
