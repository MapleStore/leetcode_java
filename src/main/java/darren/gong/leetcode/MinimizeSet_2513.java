package darren.gong.leetcode;

public class MinimizeSet_2513 {
  public static void main(String[] args) {
    MinimizeSet_2513 minimizeSet_2513 = new MinimizeSet_2513();
    minimizeSet_2513.minimizeSet(92761,
        48337,
        208563424,
        9115778);
  }
  public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    long lcm = (long)divisor1*(long)divisor2/getGCD(Math.max(divisor1, divisor2), Math.min(divisor1, divisor2));
    long left = uniqueCnt1+uniqueCnt2;
    long right = 2000000000;
    while (left < right) {
      long mid = (left+right)>>1;
      if (valid(mid, uniqueCnt1, uniqueCnt2, lcm, divisor1, divisor2)) {
        right = mid;
      } else left = mid+1;
    }
    return (int)left;
  }
  private int getGCD(int divisor1, int divisor2) {
    if (divisor2 == 0) {
      return divisor1;
    }
    return getGCD(divisor2, divisor1%divisor2);
  }
  private boolean valid(long val, int u1, int u2, long lcm, int divisor1, int divisor2) {
    long base = (val/lcm);
    long canNoFill = val/divisor1-Math.min(u2, val/divisor1-base);
    canNoFill = Math.max(canNoFill, val/divisor2-Math.min(u1, val/divisor2-base));
    if (val-canNoFill >= u1+u2) {
      return true;
    }
    return false;
  }
}
