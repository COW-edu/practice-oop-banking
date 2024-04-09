package Week2;

import java.math.BigDecimal;

public class NormalInterestCalculator implements InterestCalculator{

    // 1000만원이상은 이자율 50%, 500만원 이상은 7%, 100만원 이상은 4%, 1만원 이상은 2%, 그 외에는 1%
    public BigDecimal getInterest(BigDecimal balance){ // 계좌 잔액에 대한 이자금액 반환

        // 1590이면 1000으로 바꾸고 159면 100으로 바꿔서 하면 되나?
        String toStringBalance = balance.toString();
        char head = toStringBalance.charAt(0);
        int digit = toStringBalance.length()-1;
        String temp = head + "0".repeat(digit);
        int condition = Integer.parseInt(temp);
        switch (condition ){
            case 500: case 600: case 700: case 800: case 900:
                return balance.multiply(BigDecimal.valueOf(0.07));
            case 100: case 200: case 300: case 400:
                return balance.multiply(BigDecimal.valueOf(0.04));
            default:
                if (condition < 100 && condition >= 1) {
                    return balance.multiply(BigDecimal.valueOf(0.02));
                } else {
                    if (condition >= 1000) {
                        return balance.multiply(BigDecimal.valueOf(0.5));
                    } else {
                        return balance.multiply(BigDecimal.valueOf(0.01));
                    }
                }
        }
    }

}