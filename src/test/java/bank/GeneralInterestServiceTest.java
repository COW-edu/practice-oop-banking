package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GeneralInterestServiceTest {
    BankService bankService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        bankService = appconfig.memberService();
    }
    @Test
    //계좌생성확인
    void join() {
        //given
        BigDecimal amount = new BigDecimal("10000");
        GeneralMember generalMember = new GeneralMember("N","NAME","12345",amount,true);
        //when
        bankService.join(generalMember);
        GeneralMember getAccountInfo = bankService.getAccountInfo("12345");
        //then
        assertEquals(generalMember,getAccountInfo);
    }
    @Test
    //입금확인
    void deposit() {
        //given
        BigDecimal amount = new BigDecimal("10000");
        BigDecimal depositAmount = new BigDecimal("10000");
        GeneralMember generalMember = new GeneralMember("N","NAME","12345",amount,true);
        //when
        bankService.join(generalMember);
        bankService.deposit("12345",depositAmount);
        GeneralMember getAccountInfo = bankService.getAccountInfo("12345");
        //then
        BigDecimal answerValue = new BigDecimal("20000");
        assertEquals(answerValue,getAccountInfo.getAmount());
    }
}