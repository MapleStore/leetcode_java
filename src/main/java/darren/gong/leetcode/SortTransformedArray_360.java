package darren.gong.leetcode;

public class SortTransformedArray_360 {
  // 360. 有序转化数组
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    double mid = 0;
    if (a == 0) {
      if (b > 0) {
        mid = Double.MAX_VALUE/3;
      } else {
        mid = -Double.MAX_VALUE/3;
      }
    } else {
      mid = (double)b/(double) (-2*a);
    }
    int length = nums.length;
    int[] result = new int[length];
    int resultIndex = 0;

    int right = 0;
    while (right < length && nums[right] < mid) {
      right++;
    }
    int left = right-1;
    while (left >= 0 || right < length) {
      double leftDis = left >= 0 ? mid-nums[left] : Double.MAX_VALUE;
      double rightDis = right < length ? nums[right]-mid : Double.MAX_VALUE;
      if (leftDis < rightDis) {
        result[resultIndex++] = a*nums[left]*nums[left]+b*nums[left]+c;
        left--;
      } else {
        result[resultIndex++] = a*nums[right]*nums[right]+b*nums[right]+c;
        right++;
      }
    }
    if (result[length-1] < result[0]) {
      reverse(result);
    }
    return result;
  }
  private void reverse(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }
}
