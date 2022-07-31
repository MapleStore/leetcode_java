package darren.gong.leetcode;

public class MaxAbsValExpr1131 {
  public int maxAbsValExpr(int[] arr1, int[] arr2) {
    int[][] map = new int[][]{{1,1,1},{1,1,-1},{1,-1,1},{1,-1,-1}};
    int[] maxValue = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    int[] minValue = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

    int length = arr1.length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < 4; j++) {
        int[] currentDir = map[j];
        maxValue[j] = Math.max(maxValue[j], arr1[i]*currentDir[0]+arr2[i]*currentDir[1]+i*currentDir[2]);
        minValue[j] = Math.min(minValue[j], arr1[i]*currentDir[0]+arr2[i]*currentDir[1]+i*currentDir[2]);
      }
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < 4; i++) {
      result = Math.max(result, maxValue[i]-minValue[i]);
    }
    return result;
  }
}
