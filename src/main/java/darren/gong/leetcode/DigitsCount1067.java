package darren.gong.leetcode;

public class DigitsCount1067 {
  public static void main(String[] args) {
    DigitsCount1067 digitsCount1067 = new DigitsCount1067();
    digitsCount1067.digitsCount(0, 1, 10);
  }
  public int digitsCount(int d, int low, int high) {
    return digitsCount(d, high)-digitsCount(d, low-1);
  }
  private int digitsCount(int d, int n) {
    int base = 1;
    int result = 0;
    while (base <= n) {
      int high = n/(base*10);
      int low = n%base;
      int mid = (n/base)%10;
      if (high == 0 && d == 0) {
        break;
      }
      if (mid == d) {
        result += high*base+low+1;
      } else if (mid > d) {
        result += (high+1)*base;
      } else {
        result += high*base;
      }
      // d=0时, high=0的情况不可以加base, 上面的result算上了[0-(high-1)]*base
      if (d == 0) {
        result -= base;
      }
      base *= 10;
    }
    if (d == 0) {
      // 0需要算上一个
      return result+1;
    }
    return result;
  }
}
