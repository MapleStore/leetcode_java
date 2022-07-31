package darren.gong.leetcode;

public class MaxSideLength_1292 {
  public static void main(String[] args) {
    MaxSideLength_1292 maxSideLength_1292 = new MaxSideLength_1292();
    maxSideLength_1292.maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}}, 0);
  }
  public int maxSideLength(int[][] mat, int threshold) {
    int maxX = mat.length;
    int maxY = mat[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 1; j < maxY; j++) {
        mat[i][j] += mat[i][j-1];
      }
      if (i == 0) {
        continue;
      }
      for (int j = 0; j < maxY; j++) {
        mat[i][j] += mat[i-1][j];
      }
    }

    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int min = 0;
        int max = Math.min(i+1, j+1);

        while (min <= max) {
          int mid = min+((max-min)>>>1);
          int up = i-mid >= 0 ? mat[i-mid][j] : 0;
          int left = j-mid >= 0 ? mat[i][j-mid] : 0;
          int leftUp = i-mid >= 0 && j-mid >= 0 ? mat[i-mid][j-mid] : 0;
          int value = mat[i][j]-left-up+leftUp;
          if (value > threshold) {
            max = mid-1;
          } else {
            min = mid+1;
          }
        }
        result = Math.max(result, min-1);
      }
    }
    return result;
  }
}
