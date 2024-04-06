import bank.*;
import bank.clerk.*;
import person.Person;

public class AppConfig {

    public Person person() {
        return new Person(bankKiosk());
    }

    private BankKiosk bankKiosk() {
        return new BankKiosk(bankClerkFacade());
    }

    private BankServiceMediator bankClerkFacade() {
        return new BankServiceMediator(bankClerk(), depositClerk(), withdrawClerk(), remittanceClerk(), changeStatusClerk(), getAccountInfoClerk());
    }

    private CreateAccountClerk bankClerk() {
        return new CreateAccountClerk(bankSystem());
    }

    private DepositClerk depositClerk() {
        return new DepositClerk(bankSystem());
    }

    private WithdrawClerk withdrawClerk() {
        return new WithdrawClerk(bankSystem());
    }

    private RemittanceClerk remittanceClerk() {
        return new RemittanceClerk(bankSystem());
    }

    private ChangeStatusClerk changeStatusClerk() {
        return new ChangeStatusClerk(bankSystem());
    }

    private GetAccountInfoClerk getAccountInfoClerk() {
        return new GetAccountInfoClerk(bankSystem());
    }

    private BankSystem bankSystem() {
        return new BankSystem(BankStorage.getInstance());
    }
}
