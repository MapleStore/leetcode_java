package darren.gong.leetcode;

public class MaxValue_1802 {
  // 1802. 有界数组中指定下标处的最大值
  public int maxValue(int n, int index, int maxSum) {
    maxSum -= n;
    if (maxSum == 0) {
      return 1;
    }
    int leftPath = index;
    int rightPath = n-index;
    int high = 1;
    while (maxSum > 0) {
      // include
      int right = Math.min(high, rightPath);
      int left = Math.min(high-1, leftPath);
      if (left == leftPath && right == rightPath) {
        break;
      }
      if (maxSum >= right+left) {
        high++;
        maxSum -= left+right;
      } else {
        break;
      }
    }
    high += maxSum/n;
    return high;
  }
}
