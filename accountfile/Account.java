package accountfile;

import exception.DepositException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter

public class Account {
    protected String accountType;

    private String accountNumber;

    private String owner;

    private BigDecimal balance;

    private boolean isActivated;
    public Account(String accountNumber, BigDecimal initialDeposit) {
        isActivated = true;
        accountType = "N";
    }

    public Account(String accountNumber, String owner, BigDecimal balance){
        this(accountNumber, balance);
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountInfo(){
        return "계좌 종류:" + accountType + "\n" +
                "계좌번호:" + accountNumber + "\n" +
                "이름:" + owner + "\n" +
                "잔액:" + balance + "\n" +
                "활성화:" + isActivated;
    }

    public BigDecimal withdraw(BigDecimal value){
        if (this.balance.compareTo(value)< 0 ){
            System.out.println("잔액이 모자랍니다.");
        }else {
            this.balance = this.balance.subtract(value);
        }
        return value;
    }

    public BigDecimal deposit(BigDecimal value) throws DepositException {
        try {
            this.balance = this.balance.add(value);
        }catch (Exception e){
            throw new DepositException(e.getMessage());
        }
        return value;
    }
}
