package interestPolicy;

import bank.GeneralMember;

import java.math.BigDecimal;

import static interestPolicy.InterestList.*;



public class RateInterestPolicy implements InterestPolicy {
    @Override
    public BigDecimal interest(GeneralMember member) {
        if (member.getAccountType().equals("N")) {
            return generalInterest(member.getAmount());
        }
        if(member.getAccountType().equals("S")){
            return savingsInterest(member.getAmount());
        }
        throw new IllegalArgumentException();//예외처리 해줄것
    }

    private BigDecimal savingsInterest(BigDecimal amount) {
        if (amount.compareTo(OVERHUNDRED.getAccountAmount()) > -1){
            return amount.add(amount.multiply(OVERHUNDRED.getSavingsAccountInterest()));
        }
            return amount.add(amount.multiply(REMAIN.getSavingsAccountInterest()));
    }

    private BigDecimal generalInterest(BigDecimal amount) {
        if (amount.compareTo(OVERTHOUSAND.getAccountAmount()) > -1) { //왼쪽값이 우측값이상일경우
            return amount.add(amount.multiply(OVERTHOUSAND.getGeneralAccountInterest()));
        }
        if (amount.compareTo(OVERFIVEHUNDRED.getAccountAmount()) > -1){
            return amount.add(amount.multiply(OVERFIVEHUNDRED.getGeneralAccountInterest()));
        }
        if (amount.compareTo(OVERHUNDRED.getAccountAmount()) > -1){
            return amount.add(amount.multiply(OVERHUNDRED.getGeneralAccountInterest()));
        }
        if (amount.compareTo(OVERONE.getAccountAmount()) > -1){
            return amount.add(amount.multiply(OVERONE.getGeneralAccountInterest()));
        }
        return amount.add(amount.multiply(REMAIN.getGeneralAccountInterest()));
    }
}
