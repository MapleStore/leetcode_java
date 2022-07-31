package darren.gong.leetcode;

public class SpiralMatrixIII885 {
  public static void main(String[] args) {
    SpiralMatrixIII885 spiralMatrixIII885 = new SpiralMatrixIII885();
    spiralMatrixIII885.spiralMatrixIII(1, 4, 0, 0);
  }
  public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    int num = R*C;
    int loopNum = 1;
    int[][] result = new int[num][2];
    result[0] = new int[]{r0, c0};
    int index = 1;
    while (index < num) {
      for (int i = 0; i < loopNum; i++) {
        c0++;
        if (r0 < R && r0 >= 0 && c0 < C && c0 >= 0) {
          result[index++] = new int[]{r0, c0};
        }
      }
      for (int i = 0; i < loopNum; i++) {
        r0++;
        if (r0 < R && r0 >= 0 && c0 < C && c0 >= 0) {
          result[index++] = new int[]{r0, c0};
        }
      }
      loopNum++;
      for (int i = 0; i < loopNum; i++) {
        c0--;
        if (r0 < R && r0 >= 0 && c0 < C && c0 >= 0) {
          result[index++] = new int[]{r0, c0};
        }
      }
      for (int i = 0; i < loopNum; i++) {
        r0--;
        if (r0 < R && r0 >= 0 && c0 < C && c0 >= 0) {
          result[index++] = new int[]{r0, c0};
        }
      }
      loopNum++;
    }
    return result;
  }
}
