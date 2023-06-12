package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConfusingNumberII_1088 {
  public static void main(String[] args) {
    ConfusingNumberII_1088 confusingNumberII_1088 = new ConfusingNumberII_1088();
    confusingNumberII_1088.confusingNumberII(80);
  }
  private int result = 0;
  private int[] validNums = new int[]{0,1,6,8,9};
  private int[] map = new int[]{0,1,0,0,0,0,9,0,8,6};
  public int confusingNumberII(int n) {
    dfs(1, n);
    dfs(6, n);
    dfs(8, n);
    dfs(9, n);
    return result;
  }
  private void dfs(long num, int limit) {
    if (checkValid(num)) {
      result++;
    }
    for (int validNum : validNums) {
      long nextVal = num*10+validNum;
      if (nextVal > limit) {
        break;
      }
      dfs(nextVal, limit);
    }
  }
  private boolean checkValid(long val) {
    long temp = val;
    long compareVal = 0;
    while (temp != 0) {
      int lastDigit = (int) (temp%10);
      compareVal = compareVal*10+map[lastDigit];
      temp /= 10;
    }
    return val != compareVal;
  }
}
