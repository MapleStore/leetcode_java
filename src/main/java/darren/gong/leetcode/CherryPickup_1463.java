package darren.gong.leetcode;

public class CherryPickup_1463 {
  public static void main(String[] args) {
    CherryPickup_1463 cherryPickup_1463 = new CherryPickup_1463();
    cherryPickup_1463.cherryPickup(new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}});
  }
  public int cherryPickup(int[][] grid) {
    int maxX = grid.length;
    int maxY = grid[0].length;
    int[][] dp = new int[maxY][maxY];
    boolean[][] valid = new boolean[maxY][maxY];
    dp[0][maxY-1] = grid[0][0]+grid[0][maxY-1];
    valid[0][maxY-1] = true;
    for (int i = 1; i < maxX; i++) {
      int[][] nextDp = new int[maxY][maxY];
      boolean[][] nextValid = new boolean[maxY][maxY];
      for (int left = 0; left < maxY; left++) {
        for (int right = left; right < maxY; right++) {
          for (int preLeft = Math.max(0, left-1); preLeft <= left+1 && preLeft < maxY; preLeft++) {
            for (int preRight = Math.max(preLeft, right-1); preRight <= right+1 && preRight < maxY; preRight++) {
              if (!valid[preLeft][preRight]) {
                continue;
              }
              nextValid[left][right] = true;
              if (left == right) {
                nextDp[left][right] = Math.max(nextDp[left][right], dp[preLeft][preRight]+grid[i][left]);
              } else {
                nextDp[left][right] = Math.max(nextDp[left][right], dp[preLeft][preRight]+grid[i][left]+grid[i][right]);
              }
            }
          }
        }
      }
      dp = nextDp;
      valid = nextValid;
    }
    int result = 0;
    for (int left = 0; left < maxY; left++) {
      for (int right = left; right < maxY; right++) {
        result = Math.max(result, dp[left][right]);
      }
    }
    return result;
  }
}
