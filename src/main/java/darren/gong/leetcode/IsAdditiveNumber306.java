package darren.gong.leetcode;

public class IsAdditiveNumber306 {
  public static void main(String[] args) {
    IsAdditiveNumber306 isAdditiveNumber306 = new IsAdditiveNumber306();
    isAdditiveNumber306.isAdditiveNumber("1991001990");
  }
  private long max = Long.MAX_VALUE/10;
  public boolean isAdditiveNumber(String num) {
    return dfs(num, 0, -1, -1, 0);
  }
  private boolean dfs(String num, int index, long pre1, long pre2, int count) {
    if (index == num.length()) {
      if (count >= 3) {
        return true;
      }
      return false;
    }
    boolean result = false;
    for (int i = index+1; i <= num.length(); i++) {
      if (num.charAt(index) == '0' && i > index+1) {
        break;
      }

      long value = Long.parseLong(num.substring(index, i));
      if (value >= max) {
        return result;
      }
      if (pre1 == -1 || pre2 == -1) {
        result |= dfs(num, i, value, pre1, count+1);
      } else {
        if (value == (pre1 + pre2)) {
          return dfs(num, i, value, pre1, count+1);
        } else if (value > (pre1 + pre2)) {
          return false;
        }
      }
    }
    return result;
  }
}
