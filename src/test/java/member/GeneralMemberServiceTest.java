package member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMemberServiceTest {
    MemberService memberService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.generalMemberService();
    }
    @Test
    //계좌생성확인
    void join() {
        BigDecimal amount = new BigDecimal("10000");
        //given
        GeneralMember generalMember = new GeneralMember("N","NAME","12345",amount,true);
        //when
        memberService.join(generalMember);
        GeneralMember getAccountInfo = memberService.getAccountInfo("12345");
        //then
        assertEquals(generalMember,getAccountInfo);
    }
}