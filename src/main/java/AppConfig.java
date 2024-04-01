import bank.*;
import bank.clerk.*;
import person.Person;

public class AppConfig {

    private final CentralBank centralBank = new CentralBank();
    private final BankStorage bankStorage = new BankStorage(centralBank);
    private final BankSystem bankSystem = new BankSystem(bankStorage);

    public Person person(){
         return new Person(bankKiosk());
    }
    public BankKiosk bankKiosk(){
        return new BankKiosk(bankClerkFacade());
    }
    public BankServiceMediator bankClerkFacade(){
        return new BankServiceMediator(bankClerk(), depositClerk(), withdrawClerk(), remittanceClerk(), changeStatusClerk(), getAccountInfoClerk());
    }

    public CreateAccountClerk bankClerk() {
        return new CreateAccountClerk(bankSystem);
    }
    public DepositClerk depositClerk() {
        return new DepositClerk(bankSystem);
    }
    public WithdrawClerk withdrawClerk() {
        return new WithdrawClerk(bankSystem);
    }
    public RemittanceClerk remittanceClerk() { return new RemittanceClerk(bankSystem);}
    public ChangeStatusClerk changeStatusClerk() {
        return new ChangeStatusClerk(bankSystem);
    }
    public GetAccountInfoClerk getAccountInfoClerk() {return new GetAccountInfoClerk(bankSystem);
    }



    BankStorage getBankStorage(){
        return this.bankStorage;
    }

    CentralBank getCentralBank(){
        return this.centralBank;
    }
}
