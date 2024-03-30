package member;

import java.math.BigDecimal;
import java.util.List;

public class MemberAccountMake {
    MemberAppconfig memberAppConfig = new MemberAppconfig();
    DepositMemberService depositMemberService = memberAppConfig.depositMemberService();

    public void makeAccount(List<String> account){
        if(account.size()==4){
            makeDepositAccount(account);
            return;
        }
    }


    private void makeDepositAccount(List<String> account){
        String accountType = account.get(0);
        String name= account.get(1);
        String bankAccountNumber = account.get(2);
        BigDecimal amount = new BigDecimal(account.get(3));
        Boolean activation = true;


        DepositMember depositMember = new DepositMember(accountType,name,bankAccountNumber,amount,activation);
        depositMemberService.join(depositMember);
    }

}
