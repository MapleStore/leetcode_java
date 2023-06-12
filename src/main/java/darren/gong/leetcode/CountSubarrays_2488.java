package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrays_2488 {
  public int countSubarrays(int[] nums, int k) {
    int length = nums.length;
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, 1);
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (nums[i] != k) {
        continue;
      }
      int count = 0;
      for (int j = i-1; j >= 0; j--) {
        if (nums[j] > k) {
          count++;
        } else {
          count--;
        }
        counts.put(count, counts.getOrDefault(count, 0)+1);
      }
      count = 0;
      for (int j = i; j < length; j++) {
        if (nums[j] > k) {
          count++;
        } else if (nums[j] < k) {
          count--;
        }
        result += counts.getOrDefault(-count, 0);
        if (count == 0) {
          result += counts.getOrDefault(1, 0);
        } else {
          result += counts.getOrDefault(-count+1, 0);
        }
      }
    }
    return result;
  }
}
