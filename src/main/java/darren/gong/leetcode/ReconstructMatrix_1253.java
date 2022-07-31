package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix_1253 {
  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int maxY = colsum.length;
    int[][] tempResult = new int[2][maxY];
    for (int j = 0; j < maxY; j++) {
      if (colsum[j] == 2) {
        tempResult[0][j]++;
        upper--;
        tempResult[1][j]++;
        lower--;
      }
    }
    for (int j = 0; j < maxY; j++) {
      if (colsum[j] == 1) {
        if (upper > lower) {
          tempResult[0][j]++;
          upper--;
        } else {
          tempResult[1][j]++;
          lower--;
        }
      }
    }
    if (upper != 0 || lower != 0) {
      return new ArrayList<>();
    }
    List<Integer> one = new ArrayList<>(tempResult[0].length);
    for (int val : tempResult[0]) {
      one.add(val);
    }
    List<Integer> two = new ArrayList<>(tempResult[1].length);
    for (int val : tempResult[1]) {
      two.add(val);
    }
    List<List<Integer>> result = new ArrayList<>();
    result.add(one);
    result.add(two);
    return result;
  }
}
