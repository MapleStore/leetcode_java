package darren.gong.leetcode;

public class MinHeightShelves_1105 {
  // 1105. 填充书架
  public int minHeightShelves(int[][] books, int shelf_width) {
    int bookNum = books.length;
    // i本书能摆成的最小高度
    int[] dp = new int[bookNum];
    for (int i = 0; i < bookNum; i++) {
      int widthSum = 0;
      int high = 0;
      dp[i] = Integer.MAX_VALUE;
      for (int j = i; j >= 0; j--) {
        widthSum += books[j][0];
        if (widthSum > shelf_width) {
          break;
        }
        high = Math.max(high, books[j][1]);
        dp[i] = Math.min(dp[i], high+(j == 0 ? 0 : dp[j-1]));
      }
    }
    return dp[bookNum-1];
  }
}
