package account;

public enum EAccount /*implements Selectable*/{
    N("예금계좌", new Account()),
    S("적금계좌", new SaveAccount());

    public String getMenuName() {
        return menuName;
    }

    final String menuName;
    Account account;

//    EAccount selectEAccount(int num){
//        return EAccount.values()[num];
//    }

//    String[] getInformations(){
//        String[] returnValue = new String[values().length];
//        for (int i = 0; i < values().length; i++){
//            returnValue[i] = values()[i].menuName;
//        }
//        return returnValue;
//    }
    EAccount(String menuName, Account account) {
        this.menuName = menuName;
        this.account = account;
    }

    public static String[] nameValues(){
        int nOfValues = values().length;
        String[] returnValue = new String[nOfValues];
        for(int i = 0; i < nOfValues; i++){
            returnValue[i] = values()[i].getMenuName();
        }
        return returnValue;
    }


    public Account getAccount(){
        return this.account;
    }
    public int getAccountTypeCode(){
        return this.ordinal();
    }
}