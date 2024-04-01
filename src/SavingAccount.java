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
                "Goal Asset : ₩" + goalAmount;
    }

    public boolean compareCAGA(Account account)
    {
        return account.getAmount().compareTo(this.getGoalAsset()) > 0;
    }

    public void withdrawal(BigDecimal amount)
    {
        if(getAmount().compareTo(amount) >= 0)
        {
            if(getAmount().compareTo(getGoalAsset()) >= 0)
            {
                setAmount(getAmount().subtract(amount));
                System.out.println("WithDraw Finish! your Amount : ₩" + getAmount());
            }
            else
            {
                System.out.println("The GoalAmount was not met. The withdraw will be cancelled.");
            }
        }
        else
        {
            System.out.println("Failed WithDraw!");
        }
    }
}
