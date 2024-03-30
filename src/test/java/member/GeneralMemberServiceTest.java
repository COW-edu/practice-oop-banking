package member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMemberServiceTest {
    GeneralMemberService generalMemberService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        generalMemberService = appconfig.generalMemberService();
    }
    @Test
    //계좌생성확인
    void join() {
        BigDecimal amount = new BigDecimal("10000");
        //given
        GeneralMember generalMember = new GeneralMember("N","NAME","12345",amount,true);
        //when
        generalMemberService.join(generalMember);
        GeneralMember getAccountInfo = generalMemberService.getAccountInfo("12345");
        //then
        assertEquals(generalMember,getAccountInfo);
    }
}