package darren.gong.leetcode.offer;

public class CuttingRope_14I {
  // 剑指 Offer 14- I. 剪绳子
  public int cuttingRope(int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    return cuttingRopeHelper(n);
  }
  public int cuttingRopeHelper(int n) {
    if (n <= 3) {
      return n;
    }
    return n > 5 ? 3*cuttingRopeHelper(n-3) : 2*cuttingRopeHelper(n-2);
  }
}
