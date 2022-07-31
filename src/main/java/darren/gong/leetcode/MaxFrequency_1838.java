package darren.gong.leetcode;

import java.util.Arrays;

public class MaxFrequency_1838 {
  public static void main(String[] args) {
    MaxFrequency_1838 maxFrequency_1838 = new MaxFrequency_1838();
    maxFrequency_1838.maxFrequency(new int[]{1,2,4}, 5);
  }
  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int length = nums.length;
    int leftIndex = 0;
    int rightIndex = 0;
    int currentK = 0;
    int result = Integer.MIN_VALUE;
    while (rightIndex < length) {
      currentK += rightIndex == 0 ? 0 : (rightIndex-leftIndex)*(nums[rightIndex]-nums[rightIndex-1]);
      while (currentK > k) {
        currentK -= nums[rightIndex]-nums[leftIndex];
        leftIndex++;
      }
      result = Math.max(result, rightIndex-leftIndex+1);
      rightIndex++;
    }
    return result;
  }
}
