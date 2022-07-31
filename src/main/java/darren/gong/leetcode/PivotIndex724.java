package darren.gong.leetcode;

public class PivotIndex724 {
  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return 0;
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] += i-1 < 0 ? 0 : nums[i-1];
    }
    int sum = nums[nums.length-1];
    for (int i = 0; i < nums.length; i++) {
      int pre = i-1 < 0 ? 0 : nums[i-1];
      if (pre == sum-nums[i]) {
        return i;
      }
    }
    return -1;
  }
}
