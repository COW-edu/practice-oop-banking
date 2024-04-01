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
        memberService = appconfig.memberService();
    }
    @Test
    //계좌생성확인
    void join() {
        //given
        BigDecimal amount = new BigDecimal("10000");
        GeneralMember generalMember = new GeneralMember("N","NAME","12345",amount,true);
        //when
        memberService.join(generalMember);
        GeneralMember getAccountInfo = memberService.getAccountInfo("12345");
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
        memberService.join(generalMember);
        memberService.deposit("12345",depositAmount);
        GeneralMember getAccountInfo = memberService.getAccountInfo("12345");
        //then
        BigDecimal answerValue = new BigDecimal("20000");
        assertEquals(answerValue,getAccountInfo.getAmount());
    }
}