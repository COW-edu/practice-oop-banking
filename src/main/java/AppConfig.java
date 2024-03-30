import Interest.DepositInterest;
import Interest.SavingInterest;
import account.DepositAccount;
import account.SavingAccount;
import bank.BankKiosk;
import bank.BankStorage;
import bank.BankSystem;
import person.Person;

public class AppConfig {

    public Person person(){
         return new Person(bankKiosk());
    }
    public BankKiosk bankKiosk(){
        return new BankKiosk(bankClerk());
    }
    public BankClerk bankClerk() {
        return new BankClerk(bankSystem());
    }
    public BankSystem bankSystem() {
        return new BankSystem(bankStorage());
    }
    public BankStorage bankStorage() {
        return new BankStorage();
    }
    public void accountConfig(){
        new SavingAccount(new SavingInterest());
        new DepositAccount(new DepositInterest());
    }
}
