package darren.gong.leetcode;

public class MaximumScore_1793 {
  public int maximumScore(int[] nums, int k) {
    int length = nums.length;
    int[] min = new int[length];
    min[k] = nums[k];
    for (int i = k+1; i < length; i++) {
      min[i] = Math.min(nums[i], min[i-1]);
    }
    for (int i = k-1; i >= 0; i--) {
      min[i] = Math.min(nums[i], min[i+1]);
    }
    int result = 0;
    for (int i = 0; i <= k; i++) {
      int left = k;
      int right = nums.length-1;
      while (left < right) {
        int mid = (left+right+1)>>1;
        if (min[mid] >= min[i]) {
          left = mid;
        } else {
          right = mid-1;
        }
      }
      result = Math.max(result, min[i]*(right-i+1));
    }
    for (int j = k; j < length; j++) {
      int left = 0;
      int right = k;
      while (left < right) {
        int mid = (left+right)>>1;
        if (min[mid] >= min[j]) {
          right = mid;
        } else {
          left = mid+1;
        }
      }
      result = Math.max(result, min[j]*(j-right+1));
    }
    return result;
  }
}
