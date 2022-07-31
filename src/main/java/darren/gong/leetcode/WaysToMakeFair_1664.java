package darren.gong.leetcode;

public class WaysToMakeFair_1664 {
  public static void main(String[] args) {
    WaysToMakeFair_1664 waysToMakeFair_1664 = new WaysToMakeFair_1664();
    waysToMakeFair_1664.waysToMakeFair(new int[]{2,1,6,4});
  }
  // 1664. 生成平衡数组的方案数
  public int waysToMakeFair(int[] nums) {
    int length = nums.length;
    int[] leftSum = new int[length];
    int[] rightSum = new int[length];
    for (int i = 0; i < length; i++) {
      leftSum[i] = nums[i] + (i >= 2 ? leftSum[i-2] : 0);
    }
    for (int i = length-1; i >= 0; i--) {
      rightSum[i] = nums[i] + (i+2 < length ? rightSum[i+2] : 0);
    }

    int result = 0;
    for (int i = 0; i < length; i++) {
      int oneDistance1 = i-1 >= 0 ? leftSum[i-1] : 0;
      int oneDistance2 = i+2 < length ? rightSum[i+2] : 0;

      int twoDistance1 = i-2 >= 0 ? leftSum[i-2] : 0;
      int twoDistance2 = i+1 < length ? rightSum[i+1] : 0;
      if (oneDistance1+oneDistance2 == twoDistance1+twoDistance2) {
        result++;
      }
    }
    return result;
  }
}
