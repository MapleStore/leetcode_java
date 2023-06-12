package darren.gong.leetcode;

public class StoneGameV_1563 {
  public static void main(String[] args) {
    StoneGameV_1563 stoneGameV_1563 = new StoneGameV_1563();
    stoneGameV_1563.stoneGameV(new int[]{6,2,3,4,5,5});
  }
  public int stoneGameV(int[] stoneValue) {
    int length = stoneValue.length;
    int[] prefix = new int[length];
    prefix[0] = stoneValue[0];
    for (int i = 1; i < length; i++) {
      prefix[i] = prefix[i-1]+stoneValue[i];
    }
    int[][] dp = new int[length][length];
    for (int distance = 2; distance <= length; distance++) {
      for (int left = 0; left < length; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        for (int mid = left; mid < right; mid++) {
          int leftVal = prefix[mid]-(left == 0 ? 0 : prefix[left-1]);
          int rightVal = prefix[right]-prefix[mid];
          if (leftVal > rightVal) {
            dp[left][right] = Math.max(dp[left][right], dp[mid+1][right]+rightVal);
          } else if (rightVal > leftVal) {
            dp[left][right] = Math.max(dp[left][right], dp[left][mid]+leftVal);
          } else {
            dp[left][right] = Math.max(dp[left][right], Math.max(dp[mid+1][right], dp[left][mid])+rightVal);
          }
        }
      }
    }
    return dp[0][length-1];
  }
}
