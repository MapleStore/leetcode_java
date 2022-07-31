package darren.gong.leetcode.race;

import java.util.Arrays;
import java.util.Queue;

public class LargestSubmatrix {
  public int largestSubmatrix(int[][] matrix) {
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int[][] count = new int[maxX][maxY];
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (i == 0) {
          count[i][j] = matrix[i][j] == 0 ? 0 : 1;
          continue;
        }
        count[i][j] = matrix[i][j] == 0 ? 0 : count[i-1][j]+1;
      }
    }
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      result = Math.max(result, countMax(count[i]));
    }
    return result;
  }

  private int countMax(int[] highs) {
    int length = highs.length;
    Integer[] temp = new Integer[length];
    for (int i = 0 ; i < length; i++) {
      temp[i] = highs[i];
    }
    Arrays.sort(temp, (a, b) -> (b-a));
    int result = 0;
    int width = 0;
    for (int i = 0 ; i < length; i++) {
      width++;
      result = Math.max(result, width*temp[i]);
    }
    return result;
  }
}
