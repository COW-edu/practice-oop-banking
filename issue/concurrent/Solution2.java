
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Solution2 {

  private AtomicReference<BigDecimal> balance;

  public void deposit(BigDecimal value) {
    BigDecimal prevValue;
    BigDecimal newValue;

    do {
      prevValue = balance.get(); // 현재 값 가져오기
      newValue = prevValue.add(value); // 새 값 계산
    } while (!balance.compareAndSet(prevValue, newValue)); // CAS 연산으로 안전하게 값 교체 시도

  }

  public static void main(String[] args) {
    Solution2 test = new Solution2();
    test.balance = new AtomicReference<>(BigDecimal.ZERO);

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

    System.out.println("balance: " + test.balance.get());
  }
}
