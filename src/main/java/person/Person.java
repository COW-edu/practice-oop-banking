package person;

import bank.BankKiosk;

public class Person {
    final BankKiosk service;
    PersonalInfo personalInfo;

    public Person(BankKiosk service){
        this.service = service;
        personalInfo = new PersonalInfo("한승규");
    }

    public void goToBank(){
        service.bankServiceMenu(personalInfo);
    }
}
