package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightProbability688 {
  public static void main(String[] args) {
    KnightProbability688 knightProbability688 = new KnightProbability688();
    knightProbability688.knightProbability(3,2,0,0);
  }
  public double knightProbability(int N, int K, int r, int c) {
    int[][] directions = new int[][]{{2,1},{2,-1},{-2,1},{-2,-1},{-1,2},{-1,-2},{1,2},{1,-2}};
    double[][][] dp = new double[N][N][K+1];
    dp[r][c][0] = 1;
    for (int k = 1; k <= K; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          for (int[] direction : directions) {
            int preX = i+direction[0];
            int preY = j+direction[1];
            if (preX >= 0 && preX < N && preY >= 0 && preY < N) {
              dp[i][j][k] += dp[preX][preY][k-1]/8;
            }
          }
        }
      }
    }
    double result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        result += dp[i][j][K];
      }
    }
    return result;
  }
}
