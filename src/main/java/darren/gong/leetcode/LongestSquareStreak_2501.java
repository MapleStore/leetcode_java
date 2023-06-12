package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LongestSquareStreak_2501 {
  public int longestSquareStreak(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int result = -1;
    for (int num : set) {
      int sqrt = (int) Math.sqrt(num);
      map.put(num, 1);
      if (sqrt*sqrt == num) {
        map.put(num, map.getOrDefault(sqrt, 0)+1);
        result = Math.max(result, map.get(num));
      }
    }
    return result == 1 ? -1 : result;
  }
}