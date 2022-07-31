package darren.gong.leetcode;

public class ShortestPalindrome214 {
  public static void main(String[] args) {
    ShortestPalindrome214 shortestPalindrome214 = new ShortestPalindrome214();
    shortestPalindrome214.shortestPalindrome("abcabcabc");
  }
  public String shortestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    int length = s.length();
    int[] next = getNext(s);
    int maxMatchIndex = -1;
    char[] source = new StringBuilder(s).reverse().toString().toCharArray();
    char[] pattern = s.toCharArray();
    int patternIndex = 0;
    int sourceIndex = 0;
    while (patternIndex < length && sourceIndex < length) {
      if (patternIndex == -1 || source[sourceIndex] == pattern[patternIndex]) {
        sourceIndex++;
        patternIndex++;
      } else {
        if (patternIndex > maxMatchIndex) {
          maxMatchIndex = patternIndex;
        }
        patternIndex = next[patternIndex];
      }
    }
    if (patternIndex == length) {
      return s;
    }
    return new StringBuilder(s.substring(patternIndex)).reverse().append(s).toString();
  }
  private int[] getNext(String pattern) {
    int length = pattern.length();
    char[] patternCharArr = pattern.toCharArray();
    int[] next = new int[length];
    next[0] = -1;
    int left = -1;
    int right = 0;
    while (right < length-1) {
      if (left == -1 || patternCharArr[left] == patternCharArr[right]) {
        left++;
        right++;
        next[right] = left;
      } else {
        left = next[left];
      }
    }
    return next;
  }
}
