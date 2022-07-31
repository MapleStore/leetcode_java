package darren.gong.leetcode;

public class MatrixBlockSum_1314 {
  public static void main(String[] args) {
    MatrixBlockSum_1314 matrixBlockSum_1314 = new MatrixBlockSum_1314();
    matrixBlockSum_1314.matrixBlockSum(new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}}, 1);
    System.out.println(String.valueOf(500000000000L));
  }
  public int[][] matrixBlockSum(int[][] mat, int K) {
    int maxX = mat.length;
    int maxY = mat[0].length;
    int[][] sum = new int[maxX][maxY];
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int sumUp = i-1 >= 0 ? sum[i-1][j] : 0;
        int sumLeft = j-1 >= 0 ? sum[i][j-1] : 0;
        int sumUpLeft = i-1 >= 0 && j-1 >= 0 ? sum[i-1][j-1] : 0;
        sum[i][j] = sumLeft+sumUp-sumUpLeft+mat[i][j];
      }
    }
    int[][] result = new int[maxX][maxY];
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int downX = i+K >= maxX ? maxX-1 : i+K;
        int rightY = j+K >= maxY ? maxY-1 : j+K;

        int sumUp = i-K-1 >= 0 ? sum[i-K-1][rightY] : 0;
        int sumLeft = j-K-1 >= 0 ? sum[downX][j-K-1] : 0;
        int sumUpLeft = i-K-1 >= 0 && j-K-1 >= 0 ? sum[i-K-1][j-K-1] : 0;
        result[i][j] = sum[downX][rightY]-sumUp-sumLeft+sumUpLeft;
      }
    }
    return result;
  }
}
