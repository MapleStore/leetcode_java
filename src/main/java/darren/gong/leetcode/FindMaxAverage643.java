package darren.gong.leetcode;

public class FindMaxAverage643 {
  public double findMaxAverage(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = 0;
    int sum = 0;
    int result = Integer.MIN_VALUE;
    while (right < nums.length) {
      sum += nums[right];
      if (right-left+1 >= k) {
        result = Math.max(sum, result);
        sum = sum-nums[left++];
      }
      right++;
    }

    return result == Integer.MIN_VALUE ? -1 : (double) result/k;
  }
}
