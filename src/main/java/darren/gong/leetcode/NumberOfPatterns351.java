package darren.gong.leetcode;

import java.util.Arrays;

public class NumberOfPatterns351 {
  private int result = 0;
  private int[][] conflicts = new int[][]{
      {2,6,8},
      {7},
      {0,6,8},
      {5},
      {},
      {3},
      {0,2,8},
      {1},
      {0,2,6}
  };

  public int numberOfPatterns(int m, int n) {
    for (int i = m; i <= n; i++) {
      for (int j = 0; j < 9; j++) {
        backTracking(j, i-1, new boolean[9]);
      }
    }
    return result;
  }

  private void backTracking(int current, int num, boolean[] visited) {
    if (num == 0) {
      result++;
      return;
    }
    visited[current] = true;
    for (int i = 0; i < 9; i++) {
      if (!isValid(current, i, visited)) {
        continue;
      }
      backTracking(i, num-1, visited);
    }
    visited[current] = false;
  }
  private boolean isValid(int current, int next, boolean[] visited) {
    if (visited[next] || current == next) {
      return false;
    }
    if ((current+next) % 2 == 0) {
      int mid = (current+next)/2;
      if (contains(conflicts[current], next) && !visited[mid]) {
        return false;
      }
    }
    return true;
  }
  private boolean contains(int[] array, int value) {
    for (int num : array) {
      if (value == num) {
        return true;
      }
    }
    return false;
  }
}
