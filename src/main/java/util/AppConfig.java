package util;

import BankRepository.BankRepository;
import controller.BankController;
import interest.InterestServiceImpl;
import interest.InterestService;
import interest.InterestPolicy;
import interest.RateInterestPolicy;
import bankSevice.*;
import BankRepository.BankMemoryRepository;
import view.InputView;
import view.OutputView;

public class AppConfig {
    public BankService bankService(){
        return new BankServiceImpl(bankRepository());
    }
    public static BankRepository bankRepository(){
        return new BankMemoryRepository();
    }
    public InterestService interService(){
        return new InterestServiceImpl(bankService(), interestPolicy());
    }
    public static InterestPolicy interestPolicy() {
        return new RateInterestPolicy();
    }
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public BankController bankController() {
        return new BankController(inputView(), outputView(), bankService(), interService());
    }
}
