package darren.gong.leetcode;

public class NumSubarrayProductLessThanK_713 {
  // 713. 乘积小于K的子数组
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int left = 0;
    int right = 0;
    int length = nums.length;
    int result = 0;
    int mul = 1;
    while (right < length) {
      mul *= nums[right];
      while (mul >= k && left <= right) {
        result += right-left;
        mul /= nums[left++];
      }
      right++;
    }
    while (left < length) {
      result += length-left;
      left++;
    }
    return result;
  }
}
