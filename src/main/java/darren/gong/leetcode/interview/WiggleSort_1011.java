package darren.gong.leetcode.interview;

import java.util.Arrays;

public class WiggleSort_1011 {
  public void wiggleSort(int[] nums) {
    int length = nums.length;
    Arrays.sort(nums);
    int[] old = Arrays.copyOf(nums, length);
    int big = length-1;
    int small = length/2-1;
    int index = 0;
    while (index < length) {
      nums[index++] = old[big--];
      if (small >= 0) {
        nums[index++] = old[small--];
      }
    }
    return;
  }
}
