package darren.gong.leetcode;

public class ConcatenatedBinary_1680 {
  public int concatenatedBinary(int n) {
    long result = 0;
    long MOD = 1000000007;
    int count = 1;
    int bitNum = 1;
    int tempCount = count;
    for (int i = 1; i <= n; i++) {
      result = (result<<bitNum)+i;
      result = result%MOD;
      tempCount--;
      if (tempCount == 0) {
        count = count<<1;
        tempCount = count;
        bitNum++;
      }
    }
    return (int)result;
  }
}
