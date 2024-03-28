
import java.math.BigDecimal;

public class ProblemCase {

  private BigDecimal balance;

  public void deposit(BigDecimal value) {
    balance = balance.add(value);
  }

  public static void main(String[] args) {
    ProblemCase test = new ProblemCase();
    test.balance = BigDecimal.ZERO;

    final int THREAD_COUNT = 1000;

    Thread[] threads = new Thread[THREAD_COUNT];

    for (int i = 0; i < THREAD_COUNT; i++) {
      threads[i] = new Thread(() -> test.deposit(new BigDecimal("1")));
    }

    for (Thread thread : threads) {
      thread.start();
    }

    try {
      for (Thread thread : threads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("balance: " + test.balance);
  }
}
