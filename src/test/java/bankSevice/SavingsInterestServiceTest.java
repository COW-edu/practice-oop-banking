package bankSevice;

import interest.InterestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SavingsInterestServiceTest {
    BankService bankService;
    InterestService interestService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        bankService = appconfig.bankService();
        interestService = appconfig.interService();
    }
    @Test
    //적금계좌 생성확인
    void join() {
        List<String> savingsAccount = new ArrayList<>();
        savingsAccount.add("S");
        savingsAccount.add("NAME");
        savingsAccount.add("12345");
        savingsAccount.add("10000");
        savingsAccount.add("200000");

        //when
        bankService.savingsJoin(savingsAccount);
        //then

        assertEquals(savingsAccount.get(2),  bankService.getAccountInfo("12345").getBankAccountNumber());
    }
    @Test
        //이자률 확인
    void interest() {
        List<String> savingsAccount = new ArrayList<>();
        savingsAccount.add("S");
        savingsAccount.add("NAME");
        savingsAccount.add("12345");
        savingsAccount.add("1000000");
        savingsAccount.add("2000000");
        //when
        bankService.join(savingsAccount);

        //then
        assertEquals(new BigInteger("1500000"), interestService.getInterestEstimated("12345"));
    }

}