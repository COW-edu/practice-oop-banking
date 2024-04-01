### 기존 코드

```java
package ej2;

import java.math.BigDecimal;

public class BigDecimalConcurrentTest {

  private BigDecimal balance;

  public void deposit(BigDecimal value) { // 동기화 추가
    balance = balance.add(value);
  }

  public static void main(String[] args) {
    BigDecimalConcurrentTest test = new BigDecimalConcurrentTest();
    test.balance = BigDecimal.ZERO;

    final int THREAD_COUNT = 1000; 

    Thread[] threads = new Thread[THREAD_COUNT];

		// 1000개의 멀티 스레드 환경에서 각각 1씩 더하기
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

```

테스트를 위해 기존 코드의 deposit 메소드만 간단히 구현했습니다. (직접 테스트해보는 것을 추천합니다.)

## 문제점

하나의 스레드만 작동하는 `단일 스레드 환경`에서, 기존 deposit 메소드의 방식은 문제되지 않습니다.

하지만, 위 코드에서 테스트한 것처럼 1000개의 스레드 (동시에 1000개의 스레드가 실행)되는 `멀티 스레드 환경`에서는 `동시성 문제`가 발생할 수 있습니다.

실제로 위 코드를 실행해보면, 1000개의 스레드가 `1원` 씩 입금하는 상황에서, 실제 결과값은 우리가 생각하는 기댓값인 `1000` 보다 작은 값이 출력되는 것을 확인할 수 있습니다.

<img width="457" alt="스크린샷 2024-03-29 오전 2 09 16" src="https://github.com/COW-edu/practice-oop-banking/assets/104254012/287eb4fc-0417-4eca-8157-0dab1cf9f2fa">


## 동시성 문제란?

한 코어(프로세스)에서 여러 개의 스레드를 이용해 번갈아 작업을 처리하는 `멀티스레드 환경` 에서, 여러 스레드가 같은 자원을 공유함으로써 하나의 자원을 두고 위와 같은 문제가 발생하는 것입니다.

<img width="443" alt="스크린샷 2024-03-29 오전 2 11 01" src="https://github.com/COW-edu/practice-oop-banking/assets/104254012/85ae8280-4370-40c7-9e24-dba7d107c303">

출처: https://dkswnkk.tistory.com/681

스레드 참고 자료: https://wikidocs.net/230


## 우리가 동시성 문제를 고민해야 하는 이유

이 과제의 목표는 여러분이 `객체 지향 프로그래밍`에 익숙해지기 위하여 간단한 뱅킹 시스템을 구현해보는 데 의의를 두었습니다.

하지만 여기서 한 발 더 나아가서 실제 은행 시스템을 구축한다고 생각해보면, 이용자가 많을 경우 한 계좌로 짧은 시간 안에 입금(deposit)하는 상황이 발생할 수 있고,  누군가의 `balance` 가 입금되거나 인출된 이후의 값이 기댓값과 다를 때, 큰 사고로 이어질 수 있을 것입니다. 

## 해결 방법

먼저 `JAVA의 동시성 문제`에 대해 한 번 찾아보시고 보는 것을 권장합니다.

- Solution 1 - deposit 메소드에 `synchronized` 키워드 추가
    
    ```java
    public synchronized void deposit(BigDecimal value) { 
      balance = balance.add(value);
    }
    ```
    
- Solution 2 - `java.util.concurrent.atomic` 클래스 활용
    
    ```java
      private AtomicReference<BigDecimal> balance;
    
      public void deposit(BigDecimal value) {
        BigDecimal prevValue;
        BigDecimal newValue;
    
        do {
          prevValue = balance.get(); // 현재 값 가져오기
          newValue = prevValue.add(value); // 새 값 계산
        } while (!balance.compareAndSet(prevValue, newValue)); // CAS 연산으로 안전하게 값 교체 시도
    
      }
    ```
    

이외에도 동시성 문제를 제어할 수 있는 다른 방법들이 있습니다. 어떤 것들이 있는지 직접 찾아보시는 것을 추천합니다.
