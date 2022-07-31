package darren.gong.leetcode;

public class ChampagneTower_799 {
  public static void main(String[] args) {
    ChampagneTower_799 champagneTower_799 = new ChampagneTower_799();
    champagneTower_799.champagneTower(25,6,1);
  }
  public double champagneTower(int poured, int query_row, int query_glass) {
    if (query_row == 0) {
      return Math.min(poured, 1);
    }
    double[] row = new double[1];
    row[0] = poured;
    for (int i = 1; i <= query_row; i++) {
      double[] nextRow = new double[row.length+1];
      for (int glassIndex = 0; glassIndex < nextRow.length; glassIndex++) {
        if (glassIndex == 0) {
          nextRow[glassIndex] = Math.max((row[0]-1)/2, 0);
        } else if (glassIndex == nextRow.length-1) {
          nextRow[glassIndex] = Math.max((row[row.length-1]-1)/2, 0);
        } else {
          nextRow[glassIndex] = Math.max((row[glassIndex-1]-1)/2, 0)+Math.max((row[glassIndex]-1)/2, 0);
        }
      }
      row = nextRow;
    }
    return Math.min(row[query_glass], 1);
  }
}
