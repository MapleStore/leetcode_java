package darren.gong.leetcode;

public class ReorderedPowerOf2_869 {
  // 869. 重新排序得到 2 的幂
  public boolean reorderedPowerOf2(int n) {
    int[] nums = countNum(n);
    long value = 1;
    while (value < Integer.MAX_VALUE) {
      int[] current = countNum((int)value);
      if (same(current, nums)) {
        return true;
      }
      value = (value<<1);
    }
    return false;
  }
  private int[] countNum(int n) {
    int[] result = new int[10];
    while (n > 0) {
      result[n%10]++;
      n /= 10;
    }
    return result;
  }
  private boolean same(int[] one, int[] two) {
    for (int i = 0; i < 10; i++) {
      if (one[i] != two[i]) {
        return false;
      }
    }
    return true;
  }
}
