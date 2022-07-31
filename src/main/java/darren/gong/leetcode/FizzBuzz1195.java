package darren.gong.leetcode;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz1195 {
  private int n;
  private int i = 1;
  private volatile AtomicInteger value = new AtomicInteger(1);
  public FizzBuzz1195(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    synchronized (this) {
      while (i <= n) {
        if (!(i % 5 != 0 && i % 3 == 0)) {
          wait();
          continue;
        }
        printFizz.run();
        i++;
        notifyAll();
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    synchronized (this) {
      while (i <= n) {
        if (!(i % 5 == 0 && i % 3 != 0)) {
          wait();
          continue;
        }
        printBuzz.run();
        i++;
        notifyAll();
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    synchronized (this) {
      while (i <= n) {
        if (!(i % 5 == 0 && i % 3 == 0)) {
          wait();
          continue;
        }
        printFizzBuzz.run();
        i++;
        notifyAll();
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    synchronized (this) {
      while (i <= n) {
        if (!(i % 5 != 0 && i % 3 != 0)) {
          wait();
          continue;
        }
        printNumber.accept(i);
        i++;
        notifyAll();
      }
    }
  }

  // printFizz.run() outputs "fizz".
  public void fizz1(Runnable printFizz) throws InterruptedException {
    while (true) {
      int current = value.intValue();
      if (current > n) {
        break;
      }
      if (!(current % 5 != 0 && current % 3 == 0)) {
        continue;
      }
      printFizz.run();
      value.incrementAndGet();
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz1(Runnable printBuzz) throws InterruptedException {
    while (true) {
      int current = value.intValue();
      if (current > n) {
        break;
      }
      if (!(current % 5 == 0 && current % 3 != 0)) {
        continue;
      }
      printBuzz.run();
      value.incrementAndGet();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz1(Runnable printFizzBuzz) throws InterruptedException {
      while (true) {
        int current = value.intValue();
        if (current > n) {
          break;
        }
        if (!(current % 5 == 0 && current % 3 == 0)) {
          continue;
        }
        printFizzBuzz.run();
        value.incrementAndGet();
      }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number1(IntConsumer printNumber) throws InterruptedException {
    while (true) {
      int current = value.intValue();
      if (current > n) {
        break;
      }
      if (!(current % 5 != 0 && current % 3 != 0)) {
        continue;
      }
      printNumber.accept(value.intValue());
      value.incrementAndGet();
    }
  }

  public static void main(String[] args) {
    FizzBuzz1195 pfb = new FizzBuzz1195(15);
    Thread t1 = new Thread(() -> {
      try {
        pfb.fizz1(() -> System.out.print("fizz"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t2 = new Thread(() -> {
      try {
        pfb.buzz1(() -> System.out.print("buzz"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t3 = new Thread(() -> {
      try {
        pfb.fizzbuzz1(() -> System.out.print("fizzbuzz"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t4 = new Thread(() -> {
      try {
        pfb.number1(value -> System.out.print(value));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }

}
