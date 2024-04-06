package person;

import bank.BankKiosk;
import global.GlobalScanner;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor
public class Person {

    private final BankKiosk service;

    public void doBanking() {
        service.bankServiceMenu();
    }
}

