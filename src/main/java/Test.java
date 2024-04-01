import account.DepositAccount;
import bank.BankServiceMediator;
import bank.BankStorage;
import bank.CentralBank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String []args){
        Test test = new Test();
        //test.createAccount(test.setServiceMediator());
        //test.deposit(test.setServiceMediator(), test.setBankStorage());
        //test.withdraw(test.setServiceMediator(), test.setBankStorage());
        //test.remittance(test.setServiceMediator(), test.setBankStorage());
        //test.changeAccountStatus(test.setServiceMediator(),test.setBankStorage());
        test.showCentralBankAccountList();
    }



    public void createAccount(BankServiceMediator bankServiceMediator){
        bankServiceMediator.executeAction(1);
    }
    public void deposit(BankServiceMediator bankServiceMediator, BankStorage bankStorage){
        setAccount(bankStorage);
        bankServiceMediator.executeAction(2);
    }

    public void withdraw(BankServiceMediator bankServiceMediator, BankStorage bankStorage){
        setAccount(bankStorage);
        bankServiceMediator.executeAction(3);
    }

    public void remittance(BankServiceMediator bankServiceMediator, BankStorage bankStorage){
        setAccount(bankStorage);
        bankServiceMediator.executeAction(4);
    }

    public void changeAccountStatus(BankServiceMediator bankServiceMediator, BankStorage bankStorage){
        setAccount(bankStorage);
        bankServiceMediator.executeAction(5);
    }
    private void showCentralBankAccountList() {
        List<Object> classInfo = setBankStorageCentralBank();

        setAccount((BankStorage) classInfo.get(0));
        CentralBank centralBank = (CentralBank) classInfo.get(1);
        centralBank.showAccountList();
    }



    public BankServiceMediator setServiceMediator(){
        AppConfig appConfig = new AppConfig();
        return appConfig.bankClerkFacade();
    }
    public BankStorage setBankStorage(){
        AppConfig appConfig = new AppConfig();
        return appConfig.getBankStorage();
    }
    public List<Object> setBankStorageCentralBank(){
        AppConfig appConfig = new AppConfig();
        return new ArrayList<>(Arrays.asList(appConfig.getBankStorage(), appConfig.getCentralBank()));
    }
    public CentralBank setCentralBank(){
        AppConfig appConfig = new AppConfig();
        return appConfig.getCentralBank();
    }

    public void setAccount(BankStorage bankStorage){
        bankStorage.save(new DepositAccount("N", "1111111111", "홍길동", new BigDecimal("0"), true));
        bankStorage.save(new DepositAccount("N", "2222222222", "한승규", new BigDecimal("0"), true));
    }
}
