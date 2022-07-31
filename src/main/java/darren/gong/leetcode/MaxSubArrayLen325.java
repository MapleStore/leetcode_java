package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayLen325 {
  public static void main(String[] args) {
    MaxSubArrayLen325 maxSubArrayLen325 = new MaxSubArrayLen325();
    maxSubArrayLen325.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3);
  }
  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> sumToIndex = new HashMap<>();
    sumToIndex.put(0, -1);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int pre = i == 0 ? 0 : nums[i-1];
      int sum = pre+nums[i];
      nums[i] = sum;
      int diff = sum-k;
      Integer diffIndex = sumToIndex.get(diff);
      if (diffIndex != null) {
        result = Math.max(result, i-diffIndex);
      }
      if (!sumToIndex.containsKey(sum)) {
        sumToIndex.put(sum, i);
      }
    }
    return result;
  }
}
