package darren.gong.leetcode;

public class NumSubmat_1504 {
  // 1504. 统计全 1 子矩形
  public int numSubmat(int[][] mat) {
    int maxX = mat.length;
    int maxY = mat[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 1; j < maxY; j++) {
        mat[i][j] = mat[i][j] == 0 ? 0 : mat[i][j-1]+1;
      }
    }
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int min = mat[i][j];
        int temp = i;
        while (temp >= 0) {
          min = Math.min(min, mat[temp][j]);
          if (min == 0) {
            break;
          }
          result += min;
          temp--;
        }
      }
    }
    return result;
  }
}
