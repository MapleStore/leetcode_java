package darren.gong.leetcode;

import java.util.Arrays;

public class MinOperations_1775 {
  public int minOperations(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int sum1 = Arrays.stream(nums1).sum();
    int sum2 = Arrays.stream(nums2).sum();
    if (sum1 == sum2) {
      return 0;
    }
    if (sum1 < sum2) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
    }
    int count = Math.abs(sum1-sum2);
    int result = 0;
    int index1 = nums1.length-1;
    int index2 = 0;
    while (index1 >= 0 || index2 < nums2.length) {
      if (index1 < 0 || (index2 < nums2.length && 6-nums2[index2] > nums1[index1]-1)) {
        count -= 6-nums2[index2++];
      } else {
        count -= nums1[index1--]-1;
      }
      result++;
      if (count <= 0) return result;
    }
    return -1;
  }
}
