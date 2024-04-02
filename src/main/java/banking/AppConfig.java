package banking;

import banking.account.controller.BankController;
import banking.account.repository.CentralBank;
import banking.account.repository.Repository;
import banking.account.service.BankService;
import banking.account.service.Service;
import banking.account.view.BankView;

public class AppConfig {

    public BankView bankView() {
        return new BankView(bankController());
    }

    public BankController bankController(){
        return new BankController(service());
    }

    public Service service() {
        return new BankService(repository());
    }

    public Repository repository() {
        return new CentralBank();
    }


}
