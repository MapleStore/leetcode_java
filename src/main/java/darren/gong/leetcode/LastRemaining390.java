package darren.gong.leetcode;

public class LastRemaining390 {
  public int lastRemaining(int n) {
    return lastRemainingFirst(n)+1;
  }

  private int lastRemainingFirst(int n) {
    if (n == 1) {
      return 0;
    }
    return lastRemainingSecond(n/2)*2+1;
  }

  private int lastRemainingSecond(int n) {
    if (n == 1) {
      return 0;
    }
    if (n%2 == 0) {
      return lastRemainingFirst(n/2)*2;
    } else {
      return lastRemainingFirst(n/2)*2+1;
    }
  }
}
