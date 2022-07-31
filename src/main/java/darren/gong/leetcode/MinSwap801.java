package darren.gong.leetcode;

public class MinSwap801 {
  // 801. 使序列递增的最小交换次数
  public int minSwap(int[] A, int[] B) {
    int length = A.length;
    // 0 前一个不交换 1 前一个交换
    /*int[][] dp = new int[length][2];*/
    int preDpi0 = 0;
    int preDpi1 = 1;
    for (int i = 1; i < length; i++) {
      // i 不交换
      int dpi0 = Integer.MAX_VALUE;
      // i-1 不交换
      if (A[i] > A[i-1] && B[i] > B[i-1] && preDpi0 != Integer.MAX_VALUE) {
        dpi0 = Math.min(dpi0, preDpi0);
      }
      // i-1 交换
      if (A[i] > B[i-1] && B[i] > A[i-1] && preDpi1 != Integer.MAX_VALUE) {
        dpi0 = Math.min(dpi0, preDpi1);
      }

      // i 交换
      int dpi1 = Integer.MAX_VALUE;
      // i-1 不交换
      if (B[i] > A[i-1] && A[i] > B[i-1] && preDpi0 != Integer.MAX_VALUE) {
        dpi1 = Math.min(dpi1, preDpi0+1);
      }
      // i-1 交换
      if (A[i] > A[i-1] && B[i] > B[i-1] && preDpi1 != Integer.MAX_VALUE) {
        dpi1 = Math.min(dpi1, preDpi1+1);
      }
      preDpi0 = dpi0;
      preDpi1 = dpi1;
    }
    return Math.min(preDpi0, preDpi1);
  }
}
