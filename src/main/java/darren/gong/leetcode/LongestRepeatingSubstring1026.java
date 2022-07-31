package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring1026 {
  public static void main(String[] args) {
    LongestRepeatingSubstring1026 longestRepeatingSubstring1026 = new LongestRepeatingSubstring1026();
    longestRepeatingSubstring1026.longestRepeatingSubstring("abbaba");
  }
  public int longestRepeatingSubstring(String S) {
    int length = S.length();
    long modules = (long)Math.pow(2, 23);
    int[] nums = new int[length];
    for (int i = 0; i < length; i++) {
      nums[i] = S.charAt(i)-'a';
    }
    for (int i = length-1; i > 0; i--) {
      if (search(i, S, modules, nums)) {
        return i;
      }
    }
    return 0;
  }
  private boolean search(int resultLength, String s, long modules, int[] nums) {
    long mask = 1;
    long result = 0;
    for (int i = 0; i < resultLength; i++) {
      result = (result*26+nums[i])%modules;
      mask = mask*26%modules;
    }
    Set<Long> visited = new HashSet<>();
    visited.add(result);
    int right;
    for (int i = 0; (right = i+resultLength) < s.length(); i++) {
      result = (result*26+nums[right])%modules;
      result = (result-(nums[i]*mask%modules)+modules)%modules;
      if (visited.contains(result)) {
        return true;
      } else {
        visited.add(result);
      }
    }
    return false;
  }
}
