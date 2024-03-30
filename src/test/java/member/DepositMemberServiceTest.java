package member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DepositMemberServiceTest {
    DepositMemberService depositMemberService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        depositMemberService = appconfig.depositMemberService();
    }
    @Test
    //계좌생성확인
    void join() {
        BigDecimal amount = new BigDecimal("10000");
        //given
        DepositMember depositMember = new DepositMember("N","NAME","12345",amount,true);
        //when
        depositMemberService.join(depositMember);
        DepositMember getAccountInfo = depositMemberService.getAccountInfo("12345");
        //then
        assertEquals(depositMember,getAccountInfo);
    }
}