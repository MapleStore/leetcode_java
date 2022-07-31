package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstringKDistinct340 {
  public static void main(String[] args) {
    LengthOfLongestSubstringKDistinct340 lengthOfLongestSubstring3 = new LengthOfLongestSubstringKDistinct340();
    lengthOfLongestSubstring3.lengthOfLongestSubstringKDistinct("eceba", 2);
  }
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k <= 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int length = s.length();
    int result = 0;
    Map<Character, Integer> window = new HashMap<>();
    int windowLength = 0;
    while (right < length) {
      if (windowLength <= k) {
        int currentValue = window.getOrDefault(s.charAt(right), 0);
        window.put(s.charAt(right), currentValue+1);
        if (currentValue == 0) {
          windowLength++;
        }
        right++;
      }
      if (windowLength <= k) {
        result = Math.max(result, right-left);
      }
      if (windowLength > k) {
        int currentValue = window.get(s.charAt(left));
        window.put(s.charAt(left), currentValue-1);
        if (currentValue == 1) {
          windowLength--;
        }
        left++;
      }
    }
    return result;
  }
}
