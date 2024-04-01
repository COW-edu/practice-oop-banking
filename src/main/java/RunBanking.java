import person.Person;

public class RunBanking {

    public static void main(String []args){

        AppConfig appConfig = new AppConfig();
        Person person = appConfig.person();

        person.doBanking();
    }
}
