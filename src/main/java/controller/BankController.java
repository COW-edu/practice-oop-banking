package controller;

import model.Account;
import bankSevice.BankService;
import interest.InterestService;
import util.AppConfig;
import view.InputView;
import view.OutputView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ErrorMessage.WRONG_FORM;


public class BankController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BankService bankService;
    private final InterestService interestService;
    AppConfig appConfig = new AppConfig();
//    BankService bankService = appConfig.bankService();
//    InterestService interestService = appConfig.interBankService();


    public BankController(InputView inputView, OutputView outputView, BankService bankService, InterestService interestService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bankService = bankService;
        this.interestService = interestService;
    }

    private static final Map<Integer, Runnable> menuOptions = new HashMap<>();

    {
        menuOptions.put(1, this::createAccount);
        menuOptions.put(2, this::getAccountInfo);
        menuOptions.put(3, this::deposit);
        menuOptions.put(4, this::withdraw);
        menuOptions.put(5, this::transfer);
        menuOptions.put(6, this::terminateAccount);
        menuOptions.put(0, this::exitProgram);
    }


    public void run() {
        menuOptionChoice(InputView.askCategory());
    }

    private void createAccount() {
        while (true) {
            try {
                List<String> account = InputView.createAccount();
                String name = account.get(1);
                    bankService.join(account);
                run();
                OutputView.createAccountEnd(name);
                break;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(WRONG_FORM.getMessage());
            }
        }
    }

    private void getAccountInfo() {
        String accountNumber = inputView.getAccountInfo();
        Account account = bankService.getAccountInfo(accountNumber);
        outputView.setAccountInfo(account.toString(),interestService.getInterestEstimated(accountNumber));
        run();
    }

    private void exitProgram() {
        InputView.exitProgram();
    }

    private void terminateAccount() {
    }

    private void transfer() {
        List<String> transferInformation = InputView.transfer();
        bankService.withdraw(transferInformation.get(0), new BigDecimal(transferInformation.get(2)));
        bankService.deposit(transferInformation.get(1), new BigDecimal(transferInformation.get(2)));
        OutputView.transferEnd(transferInformation.get(0),transferInformation.get(1),transferInformation.get(2));
        run();
    }

    private void deposit() {
        List<String> depositInformation = InputView.deposit();
        bankService.deposit(depositInformation.get(0), new BigDecimal(depositInformation.get(1)));
        OutputView.depositMessage(depositInformation.get(0), depositInformation.get(1));
        run();

    }

    private void withdraw() {
        List<String> withdrawInformation = InputView.withdraw();
        bankService.withdraw(withdrawInformation.get(0), new BigDecimal(withdrawInformation.get(1)));
        OutputView.withdrawEndMessage(withdrawInformation.get(0), withdrawInformation.get(1));
        run();
    }


    private void menuOptionChoice(int input) {
        Runnable action = menuOptions.getOrDefault(input, this::throwException);
        action.run();
    }

    private void throwException() {
        throw new IllegalStateException();//예외처리 나중에(해당하는 숫자가 없는경우)
    }
}
