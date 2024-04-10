package Bank;

public class Account {
    private String type;
    private String accountNumber;
    private String name;
    private int balance;
    private boolean isActivated;

    public Account() {

    }

    public Account(String type, String accountNumber, String name, int balance, boolean isActivated) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.isActivated = isActivated;
    }

    // 계좌 정보 출력
    public void printAccountInfo() {
        System.out.printf("Account Number: %s, Name: %s, Balance: %,d%n", accountNumber, name, balance);
    }

    // 계좌 번호 반환
    public String getAccountNumber() {
        return accountNumber;
    }

    // 입금 기능
    public void deposit(int amount) {
        this.balance += amount;
    }

    // 출금 기능
    public void withdraw(int amount) {
        this.balance -= amount;
    }

    // 계좌 활성화/비활성화 설정
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }
}
