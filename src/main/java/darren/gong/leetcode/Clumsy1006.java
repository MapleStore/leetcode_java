package darren.gong.leetcode;

public class Clumsy1006 {
  private int N;
  public int clumsy(int N) {
    this.N = N;
    int value = countPriority();
    if (this.N > 0) {
      value = value+this.N--;
    }

    while (this.N > 0) {
      int tempValue = countPriority();
      value -= tempValue;
      if (this.N > 0) {
        value = value+this.N--;
      }
    }
    return value;
  }
  private int countPriority() {
    int value = N--;
    if (N > 0) {
      value = value*(N--);
    }
    if (N > 0) {
      value = value/(N--);
    }
    return value;
  }
}
