package controller;

import Bank.Bank;
import Bank.BankService;
import member.GeneralMember;
import member.MemberService;
import member.SavingsMember;
import util.Appconfig;
import view.InputView;
import view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BankController {

    private final InputView inputView;
    private final OutputView outputView;



    Appconfig appConfig = new Appconfig();
    MemberService memberService = appConfig.memberService();
    BankService bankService = appConfig.bankService();


    public BankController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }
    private static final Map<Integer, Runnable> menuOptions = new HashMap<>();
    {
        menuOptions.put(1, this::createAccount);
        menuOptions.put(2, this::getAccountInfo);
        menuOptions.put(3, this::deposit);
        menuOptions.put(4, this::withdraw);
        menuOptions.put(5, this::transfer);
        menuOptions.put(6, this::terminateAccount);
        menuOptions.put(0,this::exitProgram);
    }



    public void run()  {
        menuOptionChoice(InputView.askCategory());

    }  private void createAccount() {
        List<String> account = InputView.createAccount();

        String accountType = account.get(0);
        String name= account.get(1);
        String bankAccountNumber = account.get(2);
        BigDecimal amount = new BigDecimal(account.get(3));
        Boolean activation = true;

        if(account.size()==4){
            GeneralMember generalMember = new GeneralMember(accountType,name,bankAccountNumber,amount,activation);
            memberService.join(generalMember);

        }
        if(account.size()==5){
            BigDecimal goalAmount = new BigDecimal(account.get(4));
//            makeSavingsAccount(account);
            SavingsMember savingsMember = new SavingsMember(accountType,name,bankAccountNumber,amount,activation,goalAmount);
            memberService.join(savingsMember);

        }
        run();
    }
    private void getAccountInfo() {
        String accountNumber= inputView.getAccountInfo();
        Bank interestEstimated = bankService.getInterestEstimated(accountNumber);
        GeneralMember generalMember = memberService.getAccountInfo(accountNumber);
        outputView.setAccountInfo(generalMember.getAccountType(),generalMember.getBankAccountNumber(),generalMember.getName(),generalMember.getAmount(),interestEstimated.getInterestAmount());
        if(generalMember.getAccountType().equals("S")){
            SavingsMember savingsMember = (SavingsMember) memberService.getAccountInfo(accountNumber);
            outputView.setAccountInfo(savingsMember.getGoalAmount());
        }
       run();

    }
    private void exitProgram() {
    }

    private void terminateAccount() {
    }

    private void transfer() {
    }

    private void deposit() {
        List<String> depositformation = InputView.deposit();
        memberService.deposit(depositformation.get(0),new BigDecimal(depositformation.get(1)));
        run();

    }

    private void withdraw() {
    }




    private void menuOptionChoice(int input) {
        Runnable action = menuOptions.getOrDefault(input, this::throwException);
        action.run();
    }

    private void throwException(){
        throw new IllegalStateException();//예외처리 나중에(해당하는 숫자가 없는경우)
    }
}
