package account;

public abstract class Account {
    enum EAccount{
        N("예금계좌"),
        S("적금계좌");

        private final String information;

        EAccount(String information) {
            this.information = information;
        }
    }

    private EAccount eAccount;
    private String accountNum;
    private String accountHolder;
    private float balance;
    private boolean isActivate;


    public EAccount getEAccount() {
        return eAccount;
    }

    public void setEAccount(EAccount eAccount) {
        this.eAccount = eAccount;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }

    public String getAccountInfo(){
        return "Account{" +
                "계좌종류 : " + eAccount.information +
                ", 계좌번호 : " + accountNum +
                ", 예금주 : " + accountHolder + '\'' +
                ", 잔액 : " + balance +
                ", 활성화 여부 : " + isActivate +
                '}';
    }


    public boolean deposit(int amount){
        try {
            balance += amount;
            return true;
        }catch (Exception e){
            System.out.println("오류가 발생했습니다");
            return false;
        }
    }

    public boolean withdraw(int amount){
        try {
            if(amount > balance)
                throw new Exception();
            else {
                balance -= amount;
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}




