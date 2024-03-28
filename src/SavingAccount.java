import java.math.BigDecimal;

public class SavingAccount extends Account
{
    private BigDecimal goalAmount;

    public SavingAccount(String accountType, String accountNum, String owner, BigDecimal amount, BigDecimal goalAmount) {
        super(accountType, accountNum, owner, amount);
        this.goalAmount = goalAmount;
    }

    public BigDecimal getGoalAsset() {return goalAmount;}
    public void setGoalAsset(BigDecimal goalAmount) {this.goalAmount = goalAmount;}

    @Override
    public String getAccountInfo()
    {
        return super.getAccountInfo() + "\n" +
                "Goal Asset: " + goalAmount;
    }


    public void withDraw(BigDecimal amount)
    {
        if (getAmount().compareTo(amount) >= 0)
        {
            super.withDraw(amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

}
