package darren.gong.leetcode;

public class NthMagicalNumber_878 {
  private int MOD = 1000000007;
  public int nthMagicalNumber(int n, int a, int b) {
    int lcm = a*b/gcd(a, b);
    long left = 0;
    long right = Long.MAX_VALUE>>1;
    while (left < right) {
      long mid = (left+right)>>1;
      long count = mid/a+mid/b-mid/lcm;
      if (count >= n) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return (int) (left%MOD);
  }
  private int gcd(int a, int b) {
    if (a < b) {
      a = a+b;
      b = a-b;
      a = a-b;
    }
    if (a%b == 0) {
      return b;
    }
    return gcd(b, a%b);
  }
}
