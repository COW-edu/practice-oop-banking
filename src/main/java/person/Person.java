package person;

import bank.BankKiosk;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person {

    private final BankKiosk service;

    public void doBanking() {
        service.bankServiceMenu();
    }
}

