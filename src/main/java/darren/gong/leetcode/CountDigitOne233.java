package darren.gong.leetcode;

public class CountDigitOne233 {
  public static void main(String[] args) {
    CountDigitOne233 countDigitOne233 = new CountDigitOne233();
    countDigitOne233.countDigitOne(1410065408);
  }
  public int countDigitOne(int n) {
    int result = 0;
    long base = 1;
    while (base <= n) {
      long high = n/(base*10);
      long cur = (n/base)%10;
      long low = n%base;
      if (cur < 1) {
        result += high*base;
      } else if (cur == 1) {
        result += high*base+low+1;
      } else {
        result += (high+1)*base;
      }
      base = base*10;
    }
    return result;
  }

}
