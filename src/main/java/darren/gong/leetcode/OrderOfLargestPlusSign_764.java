package darren.gong.leetcode;

import java.util.Arrays;

public class OrderOfLargestPlusSign_764 {
  public static void main(String[] args) {
    OrderOfLargestPlusSign_764 orderOfLargestPlusSign_764 = new OrderOfLargestPlusSign_764();
    orderOfLargestPlusSign_764.orderOfLargestPlusSign(5, new int[][]{{3,0},{3,3}});
  }
  public int orderOfLargestPlusSign(int n, int[][] mines) {
    int[][] table = new int[n][n];
    for (int[] tempTable : table) {
      Arrays.fill(tempTable, 1);
    }
    for (int[] mine : mines) {
      table[mine[0]][mine[1]] = 0;
    }
    int[][] left = new int[n][n];
    int[][] up = new int[n][n];
    int[][] right = new int[n][n];
    int[][] down = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (table[i][j] == 1) {
          left[i][j] = (j-1 >= 0 ? left[i][j-1] : 0)+1;
        }
        if (table[i][j] == 1) {
          up[i][j] += (i-1 >= 0 ? up[i-1][j] : 0)+1;
        }
      }
    }

    for (int i = n-1; i >= 0; i--) {
      for (int j = n-1; j >= 0; j--) {
        if (table[i][j] == 1) {
          right[i][j] += (j+1 < n ? right[i][j+1] : 0)+1;
        }
        if (table[i][j] == 1) {
          down[i][j] += (i+1 < n ? down[i+1][j] : 0)+1;
        }
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, Math.min(Math.min(left[i][j], up[i][j]), Math.min(right[i][j], down[i][j])));
      }
    }
    return result;
  }
}
