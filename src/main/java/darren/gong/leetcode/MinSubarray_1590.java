package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinSubarray_1590 {
  public int minSubarray(int[] nums, int p) {
    int length = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    long sum = 0;
    int result = Integer.MAX_VALUE;
    long[] postfixs = new long[length];
    for (int i = length-1; i >= 0; i--) {
      postfixs[i] = (i == length-1 ? 0 : postfixs[i+1])+nums[i];
      if (postfixs[i]%p == 0) {
        result = Math.min(result, i);
      }
    }
    for (int i = 0; i < length; i++) {
      long postfixSum = postfixs[i];
      if (map.containsKey((int)(p-postfixSum%p))) {
        result = Math.min(result, i-map.get((int)(p-postfixSum%p))-1);
      }
      sum += nums[i];
      if (sum % p == 0) {
        result = Math.min(result, length-i-1);
      }
      map.put((int) (sum%p), i);
    }
    return result == Integer.MAX_VALUE || result == length ? -1 : result;
  }
}
