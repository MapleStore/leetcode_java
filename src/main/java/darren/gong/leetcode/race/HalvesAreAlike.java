package darren.gong.leetcode.race;

public class HalvesAreAlike {
  private static boolean[] small = new boolean[26];
  private static boolean[] big = new boolean[26];

  static {
    addSmallChar(small, 'a');
    addSmallChar(small, 'e');
    addSmallChar(small, 'i');
    addSmallChar(small, 'o');
    addSmallChar(small, 'u');

    addBigChar(big, 'A');
    addBigChar(big, 'E');
    addBigChar(big, 'I');
    addBigChar(big, 'O');
    addBigChar(big, 'U');
  }
  public boolean halvesAreAlike(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    int length = s.length();
    if (length%2 != 0) {
      return false;
    }
    char[] chars = s.toCharArray();
    int left = 0;
    int right = (length>>>1);
    int leftValue = 0;
    int rightValue = 0;
    while (right < length) {
      if (contains(chars[left])) {
        leftValue++;
      }
      if (contains(chars[right])) {
        rightValue++;
      }
      left++;
      right++;
    }
    return leftValue == rightValue;
  }
  private static void addSmallChar(boolean[] small, char oneChar) {
    small[oneChar-'a'] = true;
  }
  private static void addBigChar(boolean[] big, char oneChar) {
    big[oneChar-'A'] = true;
  }
  private boolean contains(char current) {
    if (current >= 'a' && current <= 'z') {
      return small[current-'a'];
    }
    if (current >= 'A' && current <= 'Z') {
      return big[current-'A'];
    }
    return false;
  }
}
