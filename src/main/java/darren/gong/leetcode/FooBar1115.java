package darren.gong.leetcode;

public class FooBar1115 {
  private int n;
  private volatile boolean flag = true;

  public FooBar1115(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0;;) {
      synchronized (this) {
        if (flag) {
          printFoo.run();
          flag = false;
          i++;
          if (i == n) {
            notifyAll();
            break;
          }
        }
        notifyAll();
        wait();
      }
      // printFoo.run() outputs "foo". Do not change or remove this line.
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0;;) {
      synchronized (this) {
        if (!flag) {
          // printBar.run() outputs "bar". Do not change or remove this line.
          printBar.run();
          flag = true;
          i++;
          if (i == n) {
            notifyAll();
            break;
          }
        }
        notifyAll();
        wait();
      }
    }
  }
}
