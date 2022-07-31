package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset368 {
  // 368. 最大整除子集
  public List<Integer> largestDivisibleSubset(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    Arrays.sort(nums);
    int length = nums.length;
    int max = 1;
    // 0:子集多长 1:上一个数下标
    int[][] dp = new int[length][2];
    for (int i = 0; i < length; i++) {
      dp[i] = new int[]{1, -1};
      if (i == 0) {
        continue;
      }
      for (int j = i-1; j >= 0; j--) {
        if (dp[i][0] <= dp[j][0] && (nums[i]%nums[j]) == 0) {
          dp[i][0] = dp[j][0]+1;
          dp[i][1] = j;
        }
      }
      max = Math.max(dp[i][0], max);
    }
    List<Integer> result = new LinkedList<>();
    for (int i = length-1; i >= 0; i--) {
      if (dp[i][0] != max) {
        continue;
      }
      int current = i;
      while (current != -1) {
        result.add(nums[current]);
        current = dp[current][1];
      }
      break;
    }
    return result;
  }
}
