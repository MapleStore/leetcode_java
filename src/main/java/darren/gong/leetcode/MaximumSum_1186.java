package darren.gong.leetcode;

public class MaximumSum_1186 {
  public int maximumSum(int[] arr) {
    int length = arr.length;
    int[] leftMax = new int[length];
    leftMax[0] = arr[0];
    for (int i = 1; i < length; i++) {
      leftMax[i] = Math.max(arr[i], leftMax[i-1]+arr[i]);
    }
    int[] rightMax = new int[length];
    rightMax[length-1] = arr[length-1];
    for (int i = length-2; i >= 0; i--) {
      rightMax[i] = Math.max(arr[i], rightMax[i+1]+arr[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      max = Math.max(max, leftMax[i]);
    }
    for (int i = 1; i < length-1; i++) {
      if (arr[i] < 0) {
        max = Math.max(max, leftMax[i-1]+rightMax[i+1]);
      }
    }
    return max;
  }
}
