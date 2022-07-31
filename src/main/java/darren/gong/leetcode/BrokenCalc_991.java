package darren.gong.leetcode;

public class BrokenCalc_991 {
  // 991. 坏了的计算器
  public int brokenCalc(int X, int Y) {
    int result = 0;
    while (true) {
      if (X >= Y) {
        return result+X-Y;
      }
      if (Y%2 == 1) {
        Y++;
      } else {
        Y = Y/2;
      }
      result++;
    }
  }
}
