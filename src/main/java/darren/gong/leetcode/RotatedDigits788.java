package darren.gong.leetcode;

public class RotatedDigits788 {
  private static char[] notContains = new char[]{'3', '4', '7'};
  private static char[] contains = new char[]{'2', '5', '6', '9'};
  private static int[] nums = new int[10001];
  private static int end = 0;
  public int rotatedDigits(int N) {
    if (nums[N] != 0) {
      return nums[N];
    }
    for (int i = end+1; i <= N; i++) {
      if (isValidate(i)) {
        nums[i] = nums[i-1]+1;
      } else {
        nums[i] = nums[i-1];
      }
    }
    end = N;
    return nums[N];
  }
  private boolean isValidate(int num) {
    String numStr = num+"";
    for (char notContain : notContains) {
      if (numStr.indexOf(notContain) != -1) {
        return false;
      }
    }
    for (char contain : contains) {
      if (numStr.indexOf(contain) != -1) {
        return true;
      }
    }
    return false;
  }
}
