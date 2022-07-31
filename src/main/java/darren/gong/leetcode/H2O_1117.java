package darren.gong.leetcode;

public class H2O_1117 {
  private volatile int h = 2;
  private volatile int o = 0;
  public H2O_1117() {
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    synchronized (this) {
      while (true) {
        if (h == 0) {
          wait();
        } else {
          break;
        }
      }
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseHydrogen.run();
      o++;
      h--;
      notifyAll();
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    synchronized (this) {
      while (true) {
        if (o != 2) {
          wait();
        } else {
          break;
        }
      }
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseOxygen.run();
      o = 0;
      h = 2;
      notifyAll();
    }
  }
}
