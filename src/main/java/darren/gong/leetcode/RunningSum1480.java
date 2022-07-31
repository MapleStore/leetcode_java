package darren.gong.leetcode;

public class RunningSum1480 {
  public int[] runningSum(int[] nums) {
    int pre = 0;
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      pre = nums[i] = nums[i]+pre;
    }
    return nums;
  }
}
