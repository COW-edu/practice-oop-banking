import person.Person;

import java.util.Scanner;

public class Test {

    public static void main(String []args){

        AppConfig appConfig = new AppConfig();
        appConfig.accountConfig();
        Person person = appConfig.person();

        person.goToBank();
    }
}
