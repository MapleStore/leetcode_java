package darren.gong.leetcode;

import java.util.List;

public class CanPartitionKSubsets698 {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    // 注意nums[i] > 0
    int sum = 0, maxNum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (maxNum < nums[i]) maxNum = nums[i];
    }
    if (sum % k != 0 || maxNum > sum/k) return false;
    boolean[] visited = new boolean[nums.length];
    return backTracking(nums, 0, k, sum/k, sum/k, visited);
  }
  private boolean backTracking(int[] nums, int startIndex, int k, int targetValue, int need, boolean[] visited) {
    if (k == 0) {
      return true;
    }
    if (need == 0) {
      return backTracking(nums, 0, k-1, targetValue, targetValue, visited);
    }
    for (int i = startIndex; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (nums[i] <= need) {
        visited[i] = true;
/*
        不能在此处过滤，假如need为10，nums[i]为10，这里直接返回其他值是否成立，如果后面有3，7这两个数，这里不会尝试。
        if (nums[i] == need) {
          return backTracking(nums, 0, k-1, targetValue, targetValue, visited);
        }
*/
        if (backTracking(nums, i+1, k, targetValue, need-nums[i], visited)) return true;
        visited[i] = false;
      }
    }
    return false;
  }
}
