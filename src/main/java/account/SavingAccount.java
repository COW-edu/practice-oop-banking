package account;

import Interest.DepositInterest;
import Interest.InterestCalculator;
import Interest.SavingInterest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SavingAccount implements Account{

    InterestCalculator interestCalculator = new SavingInterest();
    String type;
    String accountNum;
    String name;
    BigDecimal balance;
    BigDecimal target;
    boolean status;

    public SavingAccount(String type, String accountNum, String name, BigDecimal balance, BigDecimal target, boolean status) {
        this.type = type;
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;
        this.target = target;
        this.status = status;
    }

    @Override
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String deposit(BigDecimal balance) {
        BigDecimal interest = interestCalculator.getInterest(balance);
        System.out.println(interest);
        setBalance(getBalance().add(balance.add(interest)));
        return "입금완료! [잔고] = " + getBalance();
    }

    @Override
    public String withdraw(BigDecimal balance) {
        if (validateBalance() && validateTarget()) {
            setBalance(getBalance().subtract(balance));
            return "출금완료! [잔고] = " + getBalance();}
        if (validateBalance()) return "잔액부족! [잔고] = " + getBalance();
        return "목표금액 이하! [잔고] =" + getBalance();
    }

    @Override
    public String withdrawForTransfer(BigDecimal balance) {
        if (validateBalance() && validateTarget()) {
            setBalance(getBalance().subtract(balance));
            return "[잔고] = " + getBalance();}
        if (validateBalance()) return "잔액부족! [잔고] = " + getBalance();
        return "목표금액 이하! [잔고] =" + getBalance();
    }

    @Override
    public String changeStatus() {
        if(status){
            setStatus(false);
            return "비활성화";
        }
        setStatus(true);
        return "활성화";
    }

    @Override
    public void depositForTransfer(BigDecimal balance) {
        setBalance(getBalance().add(balance));
    }
    @Override
    public String getAccountNum() {
        return this.accountNum;
    }



    public boolean validateBalance() {
        return this.getBalance().compareTo(balance) >= 0;
    }
    public boolean validateTarget() {
        return this.getTarget().compareTo(this.balance) < 0;
    }

}
