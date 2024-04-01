package banking.account.service;

import banking.account.domain.BasicAccount;
import banking.account.repository.CentralBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static banking.account.constant.AccountName.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {
    BasicAccount account;
    BigDecimal money;

    BankService bank;
    CentralBank centralBank;

    @BeforeEach
    void beforeEach() {
        bank = (BankService) BankService.getInstance();
        centralBank = (CentralBank) CentralBank.getInstance();

        init();
    }

    private void init() {
        money = new BigDecimal("10000000");
        account = new BasicAccount(BASIC, "1234-1234", "백재혁", money, true);
        centralBank.createAccount(account);
    }

    /**
     * 계좌 생성 테스트
     */
    @Test
    void createAccount() {
        BasicAccount findAccount = bank.findAccount("1234-1234");
        assertEquals(findAccount, account);
    }

    /**
     * 입금 테스트
     */
    @Test
    void depositTest() {
        bank.deposit("1234-1234", new BigDecimal(5000));
        BasicAccount findAccount = bank.findAccount("1234-1234");
        assertEquals(findAccount.getBalance(), new BigDecimal(15000));
    }

    /**
     * 출금 테스트
     */
    @Test
    void withdrawTest() {
        bank.withdraw("1234-1234", new BigDecimal(4000));
        BasicAccount findAccount = bank.findAccount("1234-1234");
        assertEquals(findAccount.getBalance(), new BigDecimal(6000));
    }

    /**
     * 송금 테스트
     */
    @Test
    void transferTest() {
        BasicAccount otherAccount = new BasicAccount(BASIC,"5656-5656", "엄마", new BigDecimal(2000), true);
        centralBank.createAccount(otherAccount);

        bank.transfer("1234-1234", "5656-5656", new BigDecimal(2000));

        assertEquals(otherAccount.getBalance(), new BigDecimal(0));
        assertEquals(account.getBalance(), new BigDecimal(12000));
    }

    /**
     * 이자 계산 테스트
     */
    @Test
    void interestTest() {
        BasicAccount bankAccount = bank.findAccount("1234-1234");
        assertEquals(bankAccount.getBalance(), new BigDecimal(15000000));
    }
}