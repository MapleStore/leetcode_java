package darren.gong.leetcode;

import java.util.Arrays;

public class MaximumGap164 {
  public static void main(String[] args) {
    MaximumGap164 maximumGap164 = new MaximumGap164();
    maximumGap164.maximumGap(new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740});
  }
  public int maximumGap(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    int base = 1;
    int length = nums.length;
    int max = Arrays.stream(nums).max().getAsInt();
    int[] temp = new int[length];
    while (base <= max) {
      int[] digitIndex = new int[10];
      for (int num : nums) {
        int currentDigit = (num/base)%10;
        digitIndex[currentDigit]++;
      }
      for (int i = 1; i < 10; i++) {
        digitIndex[i] += digitIndex[i-1];
      }
      for (int i = length-1; i >= 0; i--) {
        int currentDigit = (nums[i]/base)%10;
        temp[digitIndex[currentDigit]-1] = nums[i];
        digitIndex[currentDigit]--;
      }
      for (int i = 0; i < length; i++) {
        nums[i] = temp[i];
      }
      base = base*10;
    }
    int result = 0;
    for (int i = 1; i < length; i++) {
      result = Math.max(result, nums[i]-nums[i-1]);
    }
    return result;
  }
}
