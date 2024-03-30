package member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsMemberServiceTest {
    SavingsMemberService savingsMemberService;
    @BeforeEach()
    public void beforeEach(){
        MemberAppconfig memberAppconfig = new MemberAppconfig();
        savingsMemberService = memberAppconfig.savingsMemberService();
    }
    @Test
    //적금계좌 생성확인
    void join() {
        BigDecimal amount = new BigDecimal("10000");
        BigDecimal goalamount = new BigDecimal("100000");
        //given
        SavingsMember savingsMember = new SavingsMember("N","NAME","12345",amount,true, goalamount);
        //when
        savingsMemberService.join(savingsMember);
        SavingsMember getAccountInfo = savingsMemberService.getAccountInfo("12345");
        //then
        assertEquals(savingsMember,getAccountInfo);
    }

}