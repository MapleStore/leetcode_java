package darren.gong.leetcode;

public class SmallestCommonElement1198 {
  public int smallestCommonElement(int[][] mat) {
    if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) {
      return -1;
    }
    int maxX = mat.length;
    int maxY = mat[0].length;
    if (maxX == 1) {
      return mat[0][0];
    }
    int[] index = new int[maxX];
    for (; index[0] < maxY; index[0]++) {
      int currentNum = mat[0][index[0]];
      int contain = 1;
      for (int i = 1; i < maxX; i++) {
        while (index[i] < maxY && mat[i][index[i]] < currentNum) {
          index[i]++;
        }
        if (index[i] == maxY) {
          continue;
        }
        if (mat[i][index[i]] == currentNum) {
          contain++;
        }
      }
      if (contain == maxX) {
        return currentNum;
      }
    }
    return -1;
  }
}
