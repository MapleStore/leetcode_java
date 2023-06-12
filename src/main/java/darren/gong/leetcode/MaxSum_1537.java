package darren.gong.leetcode;

public class MaxSum_1537 {
  private final int MOD = 1000000007;
  public int maxSum(int[] nums1, int[] nums2) {
    int index1 = 0;
    int index2 = 0;
    long[] dp1 = new long[nums1.length+1];
    long[] dp2 = new long[nums2.length+1];
    while (index1 < nums1.length || index2 < nums2.length) {
      if (index1 >= nums1.length || (index2 < nums2.length && nums2[index2] < nums1[index1])) {
        dp2[index2+1] = dp2[index2]+nums2[index2];
        index2++;
      } else if (index2 >= nums2.length || nums1[index1] < nums2[index2]) {
        dp1[index1+1] = dp1[index1]+nums1[index1];
        index1++;
      } else {
        dp1[index1+1] = Math.max(dp1[index1]+nums1[index1], dp2[index2]+nums1[index1]);
        dp2[index2+1] = Math.max(dp2[index2]+nums2[index2], dp1[index1]+nums2[index2]);
        index1++;
        index2++;
      }
    }
    return (int) (Math.max(dp1[nums1.length], dp2[nums2.length])%MOD);
  }
}
