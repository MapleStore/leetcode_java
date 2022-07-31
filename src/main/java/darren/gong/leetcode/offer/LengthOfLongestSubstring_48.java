package darren.gong.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_48 {
  // 剑指 Offer 48. 最长不含重复字符的子字符串
  public int lengthOfLongestSubstring(String s) {
    char[] arr = s.toCharArray();
    int length = arr.length;
    int left = 0;
    int right = 0;
    int result = 0;
    Map<Character, Integer> count = new HashMap<>();
    while (right < length) {
      count.put(arr[right], count.getOrDefault(arr[right], 0)+1);
      while (count.get(arr[right]) > 1) {
        count.put(arr[left], count.get(arr[left])-1);
        left++;
      }
      result = Math.max(result, right-left+1);
      right++;
    }
    return result;
  }
}
