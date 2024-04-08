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

class GeneralInterestServiceTest {
    BankService bankService;
    InterestService interestService;

    @BeforeEach()
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        bankService = appconfig.bankService();
        interestService = appconfig.interService();
    }

    @Test
        //계좌생성확인
    void join() {
        //given
        List<String> generalAccount = new ArrayList<>();
        generalAccount.add("N");
        generalAccount.add("NAME");
        generalAccount.add("12345");
        generalAccount.add("10000");

        //when
        bankService.generalJoin(generalAccount);
        //then
        assertEquals(generalAccount.get(2),  bankService.getAccountInfo("12345").getBankAccountNumber());
    }

    @Test
        //입금확인
    void deposit() {
        //given
        List<String> generalAccount = new ArrayList<>();
        generalAccount.add("N");
        generalAccount.add("NAME");
        generalAccount.add("12345");
        generalAccount.add("10000");

        //when
        bankService.join(generalAccount);
        bankService.deposit("12345", new BigDecimal("10000"));
        Account getAccountInfo = bankService.getAccountInfo("12345");
        //then
        assertEquals(new BigDecimal("20000"), getAccountInfo.getAmount());
    }

    @Test
        //출금확인
    void withdraw() {
        //given
        List<String> generalAccount = new ArrayList<>();
        generalAccount.add("N");
        generalAccount.add("NAME");
        generalAccount.add("12345");
        generalAccount.add("10000");

        //when
        bankService.join(generalAccount);
        bankService.withdraw("12345", new BigDecimal("5000"));
        Account getAccountInfo = bankService.getAccountInfo("12345");
        //then
        assertEquals(new BigDecimal("5000"), getAccountInfo.getAmount());
    }

    @Test
        //이자률 확인
    void interest() {
        List<String> generalAccount = new ArrayList<>();
        generalAccount.add("N");
        generalAccount.add("NAME");
        generalAccount.add("12345");
        generalAccount.add("10000");
        //when
        bankService.join(generalAccount);

        //then
        assertEquals( new BigInteger("10200"), interestService.getInterestEstimated("12345"));
    }
}