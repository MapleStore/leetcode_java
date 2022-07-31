package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindShortestSubArray697 {
  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> appears = new HashMap<>();
    Map<Integer, Integer> startIndex = new HashMap<>();
    Map<Integer, Integer> results = new HashMap<>();
    Set<Integer> maxAppears = new HashSet<>();

    int length = nums.length;
    int maxAppear = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      int value = nums[i];
      int appear = appears.getOrDefault(value, 0)+1;
      if (appear >= maxAppear) {
        if (appear > maxAppear) {
          maxAppears = new HashSet<>();
        }
        maxAppears.add(value);
        maxAppear = appear;
      }
      appears.put(nums[i], appear);
      startIndex.putIfAbsent(value, i);
      results.put(value, i-startIndex.get(value)+1);
    }
    int result = Integer.MAX_VALUE;
    for (int value : maxAppears) {
      result = Math.min(result, results.get(value));
    }
    return result;
  }
}
