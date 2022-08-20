package darren.gong.leetcode;

import java.util.Arrays;

public class MinIncrementForUnique_945 {
  public int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);
    int minVal = nums[0];
    int result = 0;
    for (int num : nums) {
      if (num > minVal) {
        minVal = num;
      }
      result += (minVal-num);
      minVal++;
    }
    return result;
  }
}
