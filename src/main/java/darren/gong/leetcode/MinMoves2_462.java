package darren.gong.leetcode;

import java.util.Arrays;

public class MinMoves2_462 {
  // 462. 最少移动次数使数组元素相等 II
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int length = nums.length;
    int midNum = nums[length>>>1];

    int result = 0;
    for (int num : nums) {
      result += Math.abs(midNum-num);
    }
    return result;
  }
}
