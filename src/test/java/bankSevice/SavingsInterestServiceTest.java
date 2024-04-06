package bankSevice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Appconfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SavingsInterestServiceTest {
    BankService bankService;
    @BeforeEach()
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        bankService = appconfig.bankService();
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
}