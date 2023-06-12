package darren.gong.leetcode;

public class MaximumValue_2496 {
  public int maximumValue(String[] strs) {
    int result = 0;
    for (String str : strs) {
      result = Math.max(result, getVal(str));
    }
    return result;
  }
  private int getVal(String str) {
    int result = 0;
    for (char one : str.toCharArray()) {
      if (one >= '0' && one <= '9') {
        result = result*10+one-'0';
      } else {
        return str.length();
      }
    }
    return result;
  }
}
