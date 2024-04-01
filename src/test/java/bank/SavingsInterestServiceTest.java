package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsInterestServiceTest {
    BankService bankService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        bankService = appconfig.memberService();
    }
    @Test
    //적금계좌 생성확인
    void join() {
        BigDecimal amount = new BigDecimal("10000");
        BigDecimal goalamount = new BigDecimal("100000");
        //given
        SavingsMember savingsMember = new SavingsMember("N","NAME","12345",amount,true, goalamount);
        //when
        bankService.join(savingsMember);
        SavingsMember getAccountInfo = (SavingsMember) bankService.getAccountInfo("12345");
        //then
        assertEquals(savingsMember,getAccountInfo);
    }

}