package darren.gong.leetcode.race;

public class FindBall {
  public static void main(String[] args) {
    FindBall findBall = new FindBall();
    findBall.findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}});
  }
  public int[] findBall(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return new int[0];
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    int[] result = new int[maxY];
    for (int i = 0; i < maxY; i++) {
      result[i] = i;
    }
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (result[j] == -1) {
          continue;
        }
        int position = result[j];
        if (grid[i][position] == 1) {
          if (position == maxY-1 || grid[i][position+1] == -1) {
            result[j] = -1;
          } else {
            result[j]++;
          }
        } else {
          if (position == 0 || grid[i][position-1] == 1) {
            result[j] = -1;
          } else {
            result[j]--;
          }
        }
      }
    }
    return result;
  }
}
