package member;

import util.Appconfig;

import java.math.BigDecimal;
import java.util.List;

public class MemberAccountMake {
    private static String accountType;
    private static String name;
    private static String bankAccountNumber;
    private static BigDecimal amount;
    private static BigDecimal goalAmount;
    private static Boolean activation;
    Appconfig appConfig = new Appconfig();
    MemberService memberService = appConfig.memberService();


    public void makeAccount(List<String> account){
        String accountType = account.get(0);
        String name= account.get(1);
        String bankAccountNumber = account.get(2);
        BigDecimal amount = new BigDecimal(account.get(3));
        BigDecimal goalAmount = new BigDecimal(account.get(4));
        Boolean activation = true;
        if(account.size()==4){
            //makeGeneralAccount(account);
            GeneralMember generalMember = new GeneralMember(accountType,name,bankAccountNumber,amount,activation);
            memberService.join(generalMember);

            return;
        }
        if(account.size()==5){
//            makeSavingsAccount(account);
            SavingsMember savingsMember = new SavingsMember(accountType,name,bankAccountNumber,amount,activation,goalAmount);
            memberService.join(savingsMember);
            return;
        }
        return;
    }



}
