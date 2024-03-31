package account;

import Interest.DepositInterest;
import Interest.InterestCalculator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class DepositAccount implements Account{

    InterestCalculator interestCalculator = new DepositInterest();
    String type;
    String accountNum;
    String name;
    BigDecimal balance;
    boolean status;

    public DepositAccount(String type, String accountNum, String name, BigDecimal balance, boolean status) {
        this.type = type;
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;
        this.status = status;
    }

    @Override
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String deposit(BigDecimal balance){
        BigDecimal interest = interestCalculator.getInterest(balance);
        setBalance(getBalance().add(balance.add(interest)));
        return "입금완료! [잔고] = " + getBalance();
    }
    @Override
    public String withdraw(BigDecimal balance) {
        if (validateBalance()) {
            setBalance(getBalance().subtract(balance));
            return "출금완료! [잔고] = " + getBalance();}
            return "잔액부족! [잔고] = " + getBalance();}
    @Override
    public String withdrawForTransfer(BigDecimal balance) {
        if (validateBalance()) {
            setBalance(getBalance().subtract(balance));
            return "출금완료! [잔고] = " + getBalance();}
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
    public boolean validateBalance() {
        return this.getBalance().compareTo(balance) >= 0;
    }

    @Override
    public String getAccountNum() {
        return this.accountNum;
    }


}
