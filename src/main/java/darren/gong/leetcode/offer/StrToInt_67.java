package darren.gong.leetcode.offer;

public class StrToInt_67 {
  public int strToInt(String str) {
    if (str == null) {
      return 0;
    }
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    char first = str.charAt(0);
    if (first != '+' && first != '-' && (first < '0' || first > '9')) {
      return 0;
    }
    int start = 0;
    boolean positive = true;
    if (first == '+' || first == '-') {
      start++;
      positive = first == '+';
    }
    long result = 0;
    for (int i = start; i < str.length(); i++) {
      char digit = str.charAt(i);
      if (digit < '0' || digit > '9') {
        break;
      }
      result = result*10+digit-'0';
      if (result > Integer.MAX_VALUE) {
        break;
      }
    }
    return positive ? (int)Math.min(result, Integer.MAX_VALUE) : (int)Math.max(-result, Integer.MIN_VALUE);
  }
}
