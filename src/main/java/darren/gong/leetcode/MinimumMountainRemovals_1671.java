package darren.gong.leetcode;

import java.util.Stack;

public class MinimumMountainRemovals_1671 {
  public static void main(String[] args) {
    MinimumMountainRemovals_1671 minimumMountainRemovals_1671 = new MinimumMountainRemovals_1671();
    minimumMountainRemovals_1671.minimumMountainRemovals(new int[]{9,8,1,7,6,5,4,3,2,1});
  }
  public int minimumMountainRemovals(int[] nums) {
    int length = nums.length;
    int[] leftMax = new int[length];
    for (int i = 0; i < length; i++) {
      leftMax[i] = 1;
      if (i == 0) {
        continue;
      }
      for (int before = 0; before < i; before++) {
        if (nums[before] < nums[i]) {
          leftMax[i] = Math.max(leftMax[i], leftMax[before]+1);
        }
      }
    }
    int[] rightMax = new int[length];
    for (int i = length-1; i >= 0; i--) {
      rightMax[i] = 1;
      if (i == length-1) {
        continue;
      }
      for (int before = length-1; before >= 0; before--) {
        if (nums[i] > nums[before]) {
          rightMax[i] = Math.max(rightMax[i], rightMax[before]+1);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (leftMax[i] != 1 && rightMax[i] != 1) {
        result = Math.max(result, leftMax[i]+rightMax[i]-1);
      }
    }
    return length-result;
  }
}
