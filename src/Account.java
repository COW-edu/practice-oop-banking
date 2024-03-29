import java.math.BigDecimal;

public class Account
{
    private String accountType;
    private String accountNum;
    private String owner;
    private BigDecimal amount;
    private boolean activated;

    public Account(String accountType, String accountNum, String owner, BigDecimal amount)
    {
        this.accountType = accountType;
        this.accountNum = accountNum;
        this.owner = owner;
        this.amount = amount;
        this.activated = true;
    }

    public String getAccountType() {return accountType;}
    public void setAccountType(String accountType) {this.accountType = accountType;}
    public String getAccountNum() {return accountNum;}
    public void setAccountNum(String accountNum) {this.accountNum = accountNum;}
    public String getOwner() {return owner;}
    public void setOwner(String owner) {this.owner = owner;}
    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
    public boolean isActivated() {return activated;}
    public void setActivated(boolean activated) {this.activated = activated;}
    public String getAccountInfo()
    {
        // 계좌 정보를 문자열로 표현하여 반환
        return "*************************\n" +
                "Owner : " + owner + "\n" +
                "Account Type : " + accountType + "\n" +
                "Account Number : " + accountNum + "\n" +
                "Asset : ₩" + amount + "\n" +
                "Activated : " + (activated ? "Yes" : "No");
    }
    //출금
    public void withDraw(BigDecimal amount)
    {
        if(getAmount().compareTo(amount) >= 0)
        {
            setAmount(getAmount().subtract(amount));
            System.out.println("WithDraw Finish! your Amount : ₩" + getAmount());
        }
        else
        {
            System.out.println("Failed WithDraw!");
        }
    }
    //입금
    public void deposit(BigDecimal amount)
    {
        setAmount(getAmount().add(amount));
        System.out.println("Deposite Finish! Your Amount : ₩" + getAmount());
    }
    //송금
    public void transfer(Account receiver, BigDecimal amount)
    {
        if(getAmount().compareTo(amount) >= 0)
        {
            setAmount(getAmount().subtract(amount));
            receiver.setAmount(getAmount().add(amount));
            System.out.println("Sender : " + getOwner() + ", Receiver : " + receiver.getOwner());
            System.out.println("Transfer Finish! Send ₩" + amount + " To " + receiver.getOwner());
        }
        else
        {
            System.out.println("Failed Transfer From" + this.getOwner() + " To " + receiver.getOwner() + " amount " + amount );
        }
    }
}
