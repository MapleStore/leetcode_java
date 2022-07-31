package darren.gong.leetcode;

public class LongestNiceSubstring5668 {
  public String longestNiceSubstring(String s) {
    int length = s.length();
    char[] chars = s.toCharArray();
    for (int size = length; size > 0; size--) {
      for (int i = 0; i+size <= length; i++) {
        if (isNiceSubString(chars, i, i+size)) {
          return s.substring(i, i+size);
        }
      }
    }
    return "";
  }
  private boolean isNiceSubString(char[] chars, int start, int end) {
    int[] smallAppears = new int[26];
    int[] bigAppears = new int[26];

    for (int i = start; i < end; i++) {
      if (chars[i] >= 'a' && chars[i] <= 'z') {
        smallAppears[chars[i]-'a']++;
      }
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        bigAppears[chars[i]-'A']++;
      }
    }

    for (int i = start; i < end; i++) {
      if (chars[i] >= 'a' && chars[i] <= 'z') {
        if (bigAppears[chars[i]-'a'] == 0) {
          return false;
        }
      }
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        if (smallAppears[chars[i]-'A'] == 0) {
          return false;
        }
      }
    }
    return true;
  }
}
