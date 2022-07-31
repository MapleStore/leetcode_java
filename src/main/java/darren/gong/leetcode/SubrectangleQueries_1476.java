package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubrectangleQueries_1476 {
  private int[][] source;
  private List<int[]> operation = new ArrayList<>(500);
  public SubrectangleQueries_1476(int[][] rectangle) {
    this.source = rectangle;
  }

  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    operation.add(new int[]{row1, col1, row2, col2, newValue});
  }

  public int getValue(int row, int col) {
    for (int i = operation.size()-1; i >= 0; i--) {
      int[] currentOp = operation.get(i);
      if (currentOp[0] <= row && currentOp[2] >= row && currentOp[1] <= col && currentOp[3] >= col) {
        return currentOp[4];
      }
    }
    return source[row][col];
  }
}
