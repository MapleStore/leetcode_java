package darren.gong.leetcode.interview;

public class GetMaxMatrix_1724 {
  public static void main(String[] args) {
    GetMaxMatrix_1724 getMaxMatrix_1724 = new GetMaxMatrix_1724();
    getMaxMatrix_1724.getMaxMatrix(new int[][]{{-1,0},{0,-1}});
  }
  public int[] getMaxMatrix(int[][] matrix) {
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int[][] dp = new int[maxY][maxX];
    for (int y = 0; y < maxY; y++) {
      for (int x = 0; x < maxX; x++) {
        if (x == 0) {
          dp[y][x] = matrix[x][y];
          continue;
        }
        dp[y][x] = dp[y][x-1]+matrix[x][y];
      }
    }

    int[] maxPos = new int[]{0, 0, 0, 0};
    int maxResult = Integer.MIN_VALUE;
    for (int x1 = 0; x1 < maxX; x1++) {
      for (int x2 = x1; x2 < maxX; x2++) {
        int startY = 0;
        int startVal = 0;
        int currentVal = 0;
        for (int y = 0; y < maxY; y++) {
          currentVal += dp[y][x2]-(x1 == 0 ? 0 : dp[y][x1-1]);
          if (currentVal-startVal >= maxResult) {
            maxPos = new int[]{x1, startY, x2, y};
            maxResult = currentVal-startVal;
          }
          if (currentVal < startVal) {
            startVal = currentVal;
            startY = y+1;
          }
        }
      }
    }
    return maxPos;
  }
}
