package bankSevice;

import interest.InterestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;
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
        interestService = appconfig.interBankService();
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
//        BigDecimal amount = new BigDecimal("10000");
//        BigDecimal depositAmount = new BigDecimal("10000");
//        GeneralAccount generalAccount = new GeneralAccount("N", "NAME", "12345", amount, true);
//        //when
//        bankService.join(generalAccount);
//        bankService.deposit("12345", depositAmount);
//        GeneralAccount getAccountInfo = bankService.getAccountInfo("12345");
//        //then
//        BigDecimal answerValue = new BigDecimal("20000");
//        assertEquals(answerValue, getAccountInfo.getAmount());
    }

    @Test
        //출금확인
    void withdraw() {
        //given
//        BigDecimal amount = new BigDecimal("10000");
//        BigDecimal witdrawAmount = new BigDecimal("5000");
//        GeneralAccount generalAccount = new GeneralAccount("N", "NAME", "12345", amount, true);
//        //when
//        bankService.join(generalAccount);
//        bankService.withdraw("12345", witdrawAmount);
//        GeneralAccount getAccountInfo = bankService.getAccountInfo("12345");
//        //then
//        BigDecimal answerValue = new BigDecimal("5000");
//        assertEquals(answerValue, getAccountInfo.getAmount());
    }

    @Test
        //이자률 확인
    void interest() {
//        BigDecimal amount = new BigDecimal("10000");
//        BigDecimal depositAmount = new BigDecimal("10000");
//        GeneralAccount generalAccount = new GeneralAccount("N", "NAME", "12345", amount, true);
//        //when
//        bankService.join(generalAccount);
//
//        //then
//        BigDecimal answerValue = new BigDecimal("10200.00");
//        assertEquals(answerValue, interestService.getInterestEstimated("12345"));
    }
}