package account;

public enum EAccount{
    N("예금계좌", new Account()),
    S("적금계좌", new SaveAccount());

    final String information;
    Account account;

//    EAccount selectEAccount(int num){
//        return EAccount.values()[num];
//    }

//    String[] getInformations(){
//        String[] returnValue = new String[values().length];
//        for (int i = 0; i < values().length; i++){
//            returnValue[i] = values()[i].information;
//        }
//        return returnValue;
//    }
    EAccount(String information, Account account) {
        this.information = information;
        this.account = account;
    }
    public Account getAccount(){
        return this.account;
    }
    public int getAccountTypeCode(){
        return this.ordinal();
    }
}